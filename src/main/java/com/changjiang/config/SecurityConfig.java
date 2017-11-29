package com.changjiang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author hanlizhi
 * @create 2017-11-29 20:38
 */

@Configuration
@EnableWebSecurity
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
                .groupAuthoritiesByUsername("select g.id,g.group_name,f.function_name from groups"
                        + "g,group_members gm,function f where gm.username=? and g.id=f.group_id"
                        + " and g.id=gm.group_id");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**","/js/**","/images/**","/css/**",
                "/views/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //默认开启防止csrf攻击,登录登出不过滤
        http.formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter("username").passwordParameter("password").permitAll()
                .and().logout().logoutUrl("/logout").permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().authorizeRequests().antMatchers("/index", "/blog/**").permitAll().anyRequest().authenticated()
                .and().sessionManagement().maximumSessions(1).expiredUrl("/login?expired");
    }
}
