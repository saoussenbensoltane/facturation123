package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;


import com.app.security.jwt.AuthEntryPointJwt;
import com.app.security.jwt.AuthTokenFilter;
import com.app.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	        .allowedOrigins("http://localhost:4200")
	        .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
	        .allowedHeaders("Origin", "Content-Type", "Accept", "Accept-Language", "Authorization")
	        .allowCredentials(true).maxAge(3600);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers("/api/auth/**").permitAll()
        .antMatchers("/api/test/**").permitAll()
        .antMatchers("/users/public/**").permitAll()
        .antMatchers("/users/delete/{id}").hasAuthority("ROLE_ADMIN")         
        .anyRequest().authenticated();
	}
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .inMemoryAuthentication()
	                .withUser("user").password("{noop}password").roles("USER")
	                .and()
	                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	    }
}