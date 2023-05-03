package com.nadhem.produits.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//#{}[]@||<>
@EnableWebSecurity
public class SecurityConfig {

	

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.csrf().disable();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/api/all/**").hasAnyAuthority("ADMIN", "USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").hasAnyAuthority("ADMIN", "USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/**").hasAnyAuthority("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/**").hasAnyAuthority("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/**").hasAnyAuthority("ADMIN");
		
		http.authorizeHttpRequests().anyRequest().authenticated();
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
