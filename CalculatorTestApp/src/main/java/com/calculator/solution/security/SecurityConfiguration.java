package com.calculator.solution.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	
	
	
	/*
	 * protected void configure(AuthenticationManagerBuilder auth)throws Exception {
	 * auth.userDetailsService(userDetailsService); 
	 * }
	 */
	 
	
	/*
	 * In Memory Authentication for the user
	 */
	
	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws  Exception {
		  auth.inMemoryAuthentication()
	     .withUser("Shalini").password("test").roles("USER").and()
	     .withUser("demo").password("demo").roles("ADMIN"); 
	  }
	 
	

	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and().headers().frameOptions().disable()
	    .and()
	    .authorizeRequests()
	    .antMatchers("/api/*")
	    .permitAll()
	    .and().csrf().disable();	
	}
	
		
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}