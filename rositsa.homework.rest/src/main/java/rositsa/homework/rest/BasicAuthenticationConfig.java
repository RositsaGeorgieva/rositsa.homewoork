package rositsa.homework.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * 
 * JAAS in memory based security
 * 
 * @author rosy
 *
 */
@Configuration
public class BasicAuthenticationConfig {

	/**
	 * Configure auth
	 * 
	 * @param auth - spring auth
	 * 
	 * @throws Exception - security
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("parking").password("parking").roles("USER");
	}
}
