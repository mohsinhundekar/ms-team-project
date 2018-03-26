package org.nextgen.ecomm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user123").roles("USER")
				.and().withUser("admin").password("admin123").roles("ADMIN");
	}

	/*
	 * (non-Javadoc)
	 * This Method will adds the security only on the post request on products
	 * all other methods will be permitted.Making it stateless validates each and every request
	 */
	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/products/**")
				.hasRole("ADMIN")
				.anyRequest().permitAll()
				.and()
				.csrf().disable().headers().frameOptions().disable();
	}

}