package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserLogin;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UtilJWT;

/**
 * Controller donde gestionar las peticiones a la clase usuario
 * @author usuario
 *
 */

@RestController
public class UserController {
	
	 	@Autowired private UserRepository repository;
	    @Autowired private UtilJWT jwtUtil;
	    @Autowired private AuthenticationManager authManager;
	    @Autowired private PasswordEncoder passwordEncoder;

	    /**
	     * Metodo para registrar un usuario
	     * @param userUsuario que se desea añadir
	     * @return
	     */
	    @PostMapping("/auth/register")
	    public Map<String, Object> registerHandler(@RequestBody User user){
	        String encodedPass = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encodedPass);
	        user = repository.save(user);
	        String token = jwtUtil.generateToken(user.getUserName());
	        return Collections.singletonMap("jwt-token", token);
	    }

	    /**
	     * Metodo para hacer login
	     * @param userLogin usuario introducido en el formulario
	     * @return 
	     */
	    @PostMapping("/auth/login")
	    public Map<String, Object> loginHandler(@RequestBody UserLogin userLogin){
	        try {
	            UsernamePasswordAuthenticationToken authInputToken =
	            new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword());
	            System.out.println(userLogin);
	            authManager.authenticate(authInputToken);

	            String token = jwtUtil.generateToken(userLogin.getUserName());

	            return Collections.singletonMap("jwt-token", token);
	        }catch (AuthenticationException authExc){
	            throw new RuntimeException("Usuario incorrecto");
	        }
	    }
	    
	    /**
	     * Metodo para obtener un usuario mediante el token de autenticacion
	     * @return El usuario al que pertenece el token de la cabecera de la peticion
	     */
	     
	    @GetMapping("/user")
	    public User getUser(){
	        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        return repository.findById(userName).get();
	    }
    
}
