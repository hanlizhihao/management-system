package com.changjiang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Iterator;
import java.util.Locale;

@EnableTransactionManagement
@EnableRedisHttpSession
@ServletComponentScan
@MapperScan(basePackages = {"com.changjiang.dao","com.changjiang.*.dao"})
@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:db.properties"),
})
public class AppApplication {

	public static final String LANGUAGE = "language";

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return configurableEmbeddedServletContainer -> {
			ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/static/401.html");
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/static/404.html");
			ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/static/500.html");
			configurableEmbeddedServletContainer.addErrorPages(error401Page, error404Page, error500Page);
		};
	}
	/**
	 * cookie区域解析器
	 *
	 */
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver slr = new CookieLocaleResolver();
		slr.setDefaultLocale(Locale.CHINA);
		slr.setCookieMaxAge(3600);//设置cookie有效期.
		slr.setCookieName(LANGUAGE);
		return slr;
	}
}
