package com.example.demo.service;


import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Component
public class DetallesUsuarioService implements UserDetailsService {

    @Autowired private UserRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userRes = repositorio.findById(userName);
        if(userRes.isEmpty())
            throw new UsernameNotFoundException("No se pudo encontrar un usuario con el user name " + userName);
        User user = userRes.get();
        return new org.springframework.security.core.userdetails.User(
                userName,
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
