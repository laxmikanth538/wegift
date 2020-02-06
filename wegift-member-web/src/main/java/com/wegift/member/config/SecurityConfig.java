package com.wegift.member.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

import com.wegift.service.MerchantUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * private CsrfTokenRepository csrfTokenRepository() {
	 * HttpSessionCsrfTokenRepository repository = new
	 * HttpSessionCsrfTokenRepository();
	 * repository.setSessionAttributeName("_csrf"); return repository; }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("paru").password("paru").roles("MB");
		//auth.userDetailsService(newUserDetailsService());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(new String[] { "login.htm" }).access("hasRole('MB')").and().formLogin()
				.loginPage("/login.htm").loginProcessingUrl("/j_spring_security_check").usernameParameter("j_username")
				.passwordParameter("j_password").defaultSuccessUrl("/home.htm", true)
				.failureHandler(newAuthenticationFailureHandler()).and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/home.htm");

		http.csrf().disable();
		// csrfTokenRepository();
	}

	public ExceptionMappingAuthenticationFailureHandler newAuthenticationFailureHandler() {
		ExceptionMappingAuthenticationFailureHandler failureHandler = new ExceptionMappingAuthenticationFailureHandler();

		Map<String, String> failureUrlMap = new HashMap<String, String>();

		failureUrlMap.put("org.springframework.security.authentication.BadCredentialsException",
				"/login.htm?error=badCredentails");

		failureHandler.setExceptionMappings(failureUrlMap);

		return failureHandler;
	}

	@Bean
	public UserDetailsService newUserDetailsService() {
		MerchantUserDetailsServiceImpl service = new MerchantUserDetailsServiceImpl();

		return service;

	}

}
