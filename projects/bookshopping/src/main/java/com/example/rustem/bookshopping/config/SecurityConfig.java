package com.example.rustem.bookshopping.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final DataSource dataSource;

	@Bean
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl daoImpl = new JdbcDaoImpl();
		daoImpl.setDataSource(dataSource);
		return daoImpl;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/create-account").permitAll()
				.antMatchers(HttpMethod.POST, "/create-account-process").permitAll()
				.antMatchers(HttpMethod.GET, "/customers").permitAll()
				.antMatchers(HttpMethod.GET, "/rest/books").permitAll()
				.antMatchers(HttpMethod.GET, "/styles/**").permitAll()
				.antMatchers(HttpMethod.GET, "/files/**").permitAll()
				.antMatchers(HttpMethod.GET, "/confirm-order").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/orders").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/books/search").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/books/search-find-partial").permitAll()
				.antMatchers(HttpMethod.GET, "/order-confirmation-message").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/orders/save-basket-books").permitAll()
				.antMatchers(HttpMethod.POST, "/confirm-order-process").permitAll()
				.anyRequest().authenticated().and()
				.formLogin().loginPage("/show-login").loginProcessingUrl("/authenticate-user").permitAll().and()
				.logout().permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

}
