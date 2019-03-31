package com.wegift.support.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

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
		auth.inMemoryAuthentication().withUser("laxmikanth").password("laxmikanth").roles("AD");
		auth.inMemoryAuthentication().withUser("sampath").password("sampath").roles("AD");
		auth.inMemoryAuthentication().withUser("shiva").password("shiva").roles("AD");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(new String[] { "/home.htm", "/merchant-reg.htm","/merchant-enquiry.htm" }).access("hasRole('AD')")
				.and().formLogin().loginPage("/login.htm").loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("j_username").passwordParameter("j_password").defaultSuccessUrl("/home.htm", true)
				.failureHandler(newAuthenticationFailureHandler()).and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login.htm").invalidateHttpSession(true);

		http.csrf().disable();
	}

	public ExceptionMappingAuthenticationFailureHandler newAuthenticationFailureHandler() {
		ExceptionMappingAuthenticationFailureHandler failureHandler = new ExceptionMappingAuthenticationFailureHandler();

		Map<String, String> failureUrlMap = new HashMap<String, String>();

		failureUrlMap.put("org.springframework.security.authentication.BadCredentialsException",
				"/login.htm?error=badCredentails");

		failureHandler.setExceptionMappings(failureUrlMap);

		return failureHandler;
	}

}
