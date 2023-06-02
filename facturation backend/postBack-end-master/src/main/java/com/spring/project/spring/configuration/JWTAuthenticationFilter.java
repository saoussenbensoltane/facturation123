package com.spring.project.spring.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.spring.constant.SecurityParams;
import com.spring.project.spring.entities.Utilisateur;

import com.spring.project.spring.repository.OrdonnateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    @Autowired
    private OrdonnateurRepository ordonnateurRepository;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, OrdonnateurRepository ordonnateurRepository) {
        this.authenticationManager = authenticationManager;
        this.ordonnateurRepository = ordonnateurRepository;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            Utilisateur user = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getMatricule(), user.getPassword()));
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        List<String> roles = new ArrayList<>();
        System.out.println("aaa  "+user);
        Utilisateur u = this.ordonnateurRepository.findUtilisateurByMatricule(user.getUsername());

        authResult.getAuthorities().forEach(a->{
            roles.add(a.getAuthority());
        });
        String jwt = JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withClaim("idUser", u.getId())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .sign(Algorithm.HMAC256(SecurityParams.SECRET));
        response.addHeader(SecurityParams.JWT_HEADER_NAME, SecurityParams.HEADER_PREFIX+jwt);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

    }

}
