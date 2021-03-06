package com.changjiang;

import lombok.Setter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Header;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;

@EnableTransactionManagement
@EnableRedisHttpSession
@ServletComponentScan
@EnableSwagger2
@MapperScan(basePackages = {"com.changjiang.dao","com.changjiang.*.dao"})
@SpringBootApplication
@ConfigurationProperties(prefix = "app")
public class AppApplication {

	private static final String LANGUAGE = "language";

	@Setter
	private Boolean swaggerEnabled;

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

	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(swaggerEnabled)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.apiInfo(ApiInfo.DEFAULT)
				.produces(newHashSet(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessages())
				.globalResponseMessage(RequestMethod.POST, responseMessages())
				.globalResponseMessage(RequestMethod.DELETE, responseMessages())
				.globalResponseMessage(RequestMethod.PATCH, responseMessages())
				.globalResponseMessage(RequestMethod.PUT, responseMessages());
	}

	private List<ResponseMessage> responseMessages() {

		Map<String, Header> headers = newHashMap();
		headers.put("Location", new Header("Location", "登录URL", new ModelRef("")));

		return newArrayList(
				new ResponseMessageBuilder()
						.code(400)
						.message("请求参数没填好")
						.build(),
				new ResponseMessageBuilder()
						.code(401)
						.message("未授权，需要重新登录")
						.headersWithDescription(headers)
						.build(),
				new ResponseMessageBuilder()
						.code(403)
						.message("无权限!")
						.build(),
				new ResponseMessageBuilder()
						.code(404)
						.message("请求路径没有或页面跳转路径不对")
						.build(),
				new ResponseMessageBuilder()
						.code(500)
						.message("服务器端错误")
						.responseModel(new ModelRef("Errors"))
						.build());
	}
}
