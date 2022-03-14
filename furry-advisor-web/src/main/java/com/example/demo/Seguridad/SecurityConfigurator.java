package com.example.demo.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfigurator extends WebSecurityConfigurerAdapter {

	@Autowired
	UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
	 }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/createProfile").permitAll();
		http.authorizeRequests().antMatchers("/home").permitAll();
		http.authorizeRequests().antMatchers("/searchPlatform").permitAll();
		http.authorizeRequests().antMatchers("/search").permitAll();
		//Como hago para hcer publicas las urls que cuentan con un path variable y son del palo /pathvariable
		http.authorizeRequests().antMatchers("/place/{place_name}").permitAll();
		http.authorizeRequests().antMatchers("/dealImage/{header}").permitAll();
		http.authorizeRequests().antMatchers("/userImage/{header}").permitAll();
		http.authorizeRequests().antMatchers("/image/{name}").permitAll();
		http.authorizeRequests().antMatchers("/perfil").permitAll();
		
		http.authorizeRequests().anyRequest().authenticated();
		
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("userName");
		http.formLogin().passwordParameter("userPassword");
		http.formLogin().failureUrl("/home");
		http.formLogin().defaultSuccessUrl("/profile/username");
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/home");
		
		//http.csrf().disable();
	}
	

}
