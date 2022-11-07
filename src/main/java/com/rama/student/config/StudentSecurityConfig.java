package com.rama.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class StudentSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and()
				.authorizeRequests()
				.antMatchers("/api/v1/getstudents").authenticated()
				//.antMatchers("/myCards").hasAnyRole("USER", "ADMIN")
				//.antMatchers("/notices").permitAll()
				//.antMatchers("/contact").permitAll()
				.and().csrf().disable()
				.oauth2ResourceServer().jwt();

	}
}
