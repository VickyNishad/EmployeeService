package com.employee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JWTAuthenticationEntryPoint point;
	@Autowired
	private JwtAuthenticationFilter filter;
	
	private static final String[] AUTH_WHITELIST = {
	        "/v2/api-docs",
	        "/swagger-resources",
	        "/swagger-resources/**",
	        "/configuration/ui",
	        "/configuration/security",
	        "/swagger-ui.html",
	        "/webjars/**",
	        "/v3/api-docs/**",
	        "/swagger-ui/**",
	        "/api/v1/auth/login"
	};

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests()
				.requestMatchers(AUTH_WHITELIST)
				.permitAll().requestMatchers("/test").authenticated()
				// requestMatchers("/test").authenticated().requestMatchers("/swagger-ui/**",
				// "/v3/api-docs", "/webjars/**",
				// "/swagger-resources/**","api/v1/auth/login").permitAll()
				.anyRequest().authenticated().and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
