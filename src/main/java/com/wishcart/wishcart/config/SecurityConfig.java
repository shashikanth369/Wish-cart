package com.wishcart.wishcart.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String REALM_NAME = "MY_TEST_REALM";

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("shashi").password("{noop}123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("reddy").password("{noop}258").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) {
		try {
			httpSecurity.csrf().disable().authorizeRequests().antMatchers("/*/**").hasAnyRole("ADMIN", "USER").and()
					.httpBasic().realmName(REALM_NAME).authenticationEntryPoint(getBasicAuthEntryPoint()).and()
					.sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}
}
