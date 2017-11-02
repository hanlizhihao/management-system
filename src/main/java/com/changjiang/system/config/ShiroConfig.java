package com.changjiang.system.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.changjiang.system.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class ShiroConfig {

	private String host = "localhost";

	private Integer port = 6379;

/*	@Bean
	public EhCacheManager getEhCacheManager() {
		EhCacheManager em = new EhCacheManager();
		em.setCacheManagerConfigFile("classpath:config/ehcache.xml");
		return em;
	}*/

	@Bean
	public RedisManager getRedisManager(AppConfig config) {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(config.getRedis().get("host"));
		redisManager.setPort(Integer.valueOf(config.getRedis().get("port")));
		Integer expire = 1800;
		redisManager.setExpire(expire);
		return redisManager;
	}

	@Bean
	public RedisCacheManager getRedisCacheManager(RedisManager redisManager) {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager);
		return redisCacheManager;
	}

	@Bean
	public RedisSessionDAO getRedisSessionDao(RedisManager redisManager) {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager);
		return redisSessionDAO;
	}

	@Bean
	UserRealm userRealm(RedisCacheManager cacheManager) {
		UserRealm userRealm = new UserRealm();
		userRealm.setCacheManager(cacheManager);
		return userRealm;
	}

/*	@Bean
	SessionDAO sessionDAO() {
		MemorySessionDAO sessionDAO = new MemorySessionDAO();
		return sessionDAO;
	}*/

	@Bean
	public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		Collection<SessionListener> listeners = new ArrayList<>();
		listeners.add(new BDSessionListener());
		sessionManager.setSessionListeners(listeners);
		sessionManager.setSessionDAO(redisSessionDAO);
		return sessionManager;
	}

	@Bean
	SecurityManager securityManager(UserRealm userRealm, SessionManager sessionManager, RedisCacheManager redisCacheManager) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(userRealm);
		manager.setCacheManager(redisCacheManager);
		manager.setSessionManager(sessionManager);
		return manager;
	}

	@Bean
	ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/index");
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/fonts/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/docs/**", "anon");
		filterChainDefinitionMap.put("/druid/**", "anon");
		filterChainDefinitionMap.put("/upload/**", "anon");
		filterChainDefinitionMap.put("/files/**", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/blog", "anon");
		filterChainDefinitionMap.put("/blog/open/**", "anon");
		filterChainDefinitionMap.put("/**", "authc");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
		proxyCreator.setProxyTargetClass(true);
		return proxyCreator;
	}

	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			@Qualifier("securityManager") SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

}
