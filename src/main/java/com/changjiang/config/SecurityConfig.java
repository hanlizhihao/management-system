package com.changjiang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author hanlizhi
 * @create 2017-11-29 20:38
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DruidDataSource dataSource;
    @Override
    //对于权限，每个权限的名字是function_name，基于功能点去验证权限
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //暂时使用基于内存的AuthenticationProvider
        auth.inMemoryAuthentication().withUser("username").password("password").
                roles("USER");
        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("select u.username,rp.function_name from users u,role"
                        + " r,role_power rp where u.role_id=r.id and rp.role_id=r.id and "
                        + "u.username = ?")
                .groupAuthoritiesByUsername("select groups.id,groups.group_name,function.function_name from groups"
                        + ",group_members,function where group_members.username = ? and groups.id=function.group_id"
                        + " and groups.id=group_members.group_id");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/img/**","/docs/**", "common/**", "error/**", "system/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //默认开启防止csrf攻击,登录登出不过滤
        http
                .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                    .successForwardUrl("/index")
//                    .failureUrl("/login?error")
                    .and()
                .rememberMe()//开启记住我功能
                    .tokenValiditySeconds(606800)//记住一周
                    //存储在cookie中的token包含用户名、密码、过期时间和一个私钥--在写入Cookie前都进行了MD5哈希，默认私钥为SpringSecured
                    // 这里改为management
                    .key("management")
                    .and()
                .authorizeRequests()
                    .antMatchers("/blog", "/blog/**", "/index")
                    .fullyAuthenticated()
                    .anyRequest()
                    .authenticated()
                    .and()
//                .requiresChannel()
//                    .antMatchers("/login")
//                    .requiresSecure()
//                    .and()
                .httpBasic()
                    .realmName("localhost")
                    .and()
                .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .and()
                .sessionManagement()
                    .invalidSessionUrl("/login")
                    .maximumSessions(1)
                    .expiredUrl("/login?expired");
    }
}
