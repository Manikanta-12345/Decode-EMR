package com.decode;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class DecodeEmrApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DecodeEmrApplication.class, args);
	}

	 @Bean
	    public BCryptPasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }
	    @Bean
		public FilterRegistrationBean corsFilter() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration configAutenticacao = new CorsConfiguration();
			//configAutenticacao.setAllowCredentials(true);
			configAutenticacao.setAllowedHeaders(Arrays.asList("*"));
			configAutenticacao.setAllowedOrigins(Arrays.asList("*"));
			configAutenticacao.setExposedHeaders(Arrays.asList("Date"));
			configAutenticacao.addAllowedMethod("POST");
			configAutenticacao.addAllowedMethod("GET");
			configAutenticacao.addAllowedMethod("DELETE");
			configAutenticacao.addAllowedMethod("PUT");
			configAutenticacao.addAllowedMethod("OPTIONS");
			configAutenticacao.setMaxAge(3600L);
			configAutenticacao.setAllowedOrigins(Arrays.asList("*"));
			source.registerCorsConfiguration("/oauth/token", configAutenticacao);
			source.registerCorsConfiguration("/sse/**", configAutenticacao);
			source.registerCorsConfiguration("/rest/**", configAutenticacao);
			source.registerCorsConfiguration("/openapi/**", configAutenticacao);
			source.registerCorsConfiguration("/logout/**", configAutenticacao);
			source.registerCorsConfiguration("/**", configAutenticacao); // Global
																			// for
			// all paths
			FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
			return bean;
		}
	   
}
