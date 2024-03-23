package com.example.rustem.bookshopping.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
	
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http.csrf().disable()
	        .authorizeRequests()
	        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	        .requestMatchers(HttpMethod.GET, "/").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().loginPage("/show-login")
	        .loginProcessingUrl("/authenticate-user").permitAll()
	        .and()
	        .logout().permitAll()
	        .and()
	        .httpBasic()
	        .and()
	        .headers().frameOptions().disable() // Burada frameOptions'ı devre dışı bırakıyoruz
	        .and()
	        .build();
	}
	
}
