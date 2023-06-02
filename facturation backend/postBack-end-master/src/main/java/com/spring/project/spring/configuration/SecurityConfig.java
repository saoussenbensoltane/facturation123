package com.spring.project.spring.configuration;

import com.spring.project.spring.repository.OrdonnateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private OrdonnateurRepository ordonnateurRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, OrdonnateurRepository ordonnateurRepository) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.ordonnateurRepository = ordonnateurRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login").permitAll();
//        http.authorizeRequests().antMatchers("/ordonnateur/update").hasAnyAuthority("ADMINISTRATEUR");
//        http.authorizeRequests().antMatchers("/ordonnateur/getAll").hasAnyAuthority("ADMINISTRATEUR");
//        http.authorizeRequests().antMatchers("/ordonnateur/new").hasAnyAuthority("ADMINISTRATEUR");
//
//        http.authorizeRequests().antMatchers("/region/update").hasAnyAuthority("ADMINISTRATEUR");
//        http.authorizeRequests().antMatchers("/region/delete").hasAnyAuthority("ADMINISTRATEUR");
//        http.authorizeRequests().antMatchers("/region/new").hasAnyAuthority("ADMINISTRATEUR");
//
//        http.authorizeRequests().antMatchers("/typeAchat/new").hasAnyAuthority("ADMINISTRATEUR");
//        http.authorizeRequests().antMatchers("/typeAchat/update").hasAnyAuthority("ADMINISTRATEUR");
//        http.authorizeRequests().antMatchers("/typeAchat/delete").hasAnyAuthority("ADMINISTRATEUR");
//
//        http.authorizeRequests().antMatchers("/directionAchat/update").hasAnyAuthority("ADMINISTRATEUR");
//        http.authorizeRequests().antMatchers("/directionAchat/new").hasAnyAuthority("ADMINISTRATEUR");
//        http.authorizeRequests().antMatchers("/directionAchat/delete").hasAnyAuthority("ADMINISTRATEUR");





        //http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), this.ordonnateurRepository));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new
//                UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }
}