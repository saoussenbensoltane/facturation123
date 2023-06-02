package com.spring.project.spring.configuration;

import com.spring.project.spring.entities.Utilisateur;
import com.spring.project.spring.services.impl.OrdonnateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private OrdonnateurServiceImpl ordonnateurService;

    @Autowired
    public UserDetailsServiceImpl(OrdonnateurServiceImpl ordonnateurService) {
        this.ordonnateurService = ordonnateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
        System.out.println(matricule);
        Utilisateur user = this.ordonnateurService.getUserByMatricule(matricule);
        if(user == null){
            throw new UsernameNotFoundException("invalid user");
        }
        System.out.println(user.getMatricule());
        System.out.println(user.getPassword());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(r->{
            System.out.println(r);
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getMatricule(), user.getPassword(), authorities);
    }
}
