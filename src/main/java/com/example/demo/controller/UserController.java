package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ErroresManager;
import com.example.demo.error.UsuarioExistenteException;
import com.example.demo.error.UsuarioNotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.UserLogin;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UtilJWT;
import com.example.demo.service.UsuarioService;

/**
 * Controller donde gestionar las peticiones a la clase usuario
 * @author usuario
 *
 */

@RestController
public class UserController {
	
	 	@Autowired 
	 	private UserRepository repository;
	 	
	    @Autowired 
	    private UtilJWT jwtUtil;
	    
	    @Autowired 
	    private AuthenticationManager authManager;
	    
	    @Autowired 
	    private PasswordEncoder passwordEncoder;
	    
	    @Autowired
	    private UsuarioService servicioUser;

	    /**
	     * Metodo para registrar un usuario
	     * @param userUsuario que se desea añadir
	     * @return
	     */
	    @PostMapping("/auth/register")
	    public Map<String, Object> registerHandler(@RequestBody User user) throws UsuarioExistenteException{
	    	User verificar = this.repository.findById(user.getUserName()).orElse(null);
	    	if(verificar != null) {
	    		throw new UsuarioExistenteException();
	    	}
	        String encodedPass = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encodedPass);
	        user = repository.save(user);
	        String token = jwtUtil.generateToken(user.getUserName());
	        return Collections.singletonMap("jwt_token", token);
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
	            authManager.authenticate(authInputToken);

	            String token = jwtUtil.generateToken(userLogin.getUserName());

	            return Collections.singletonMap("jwt_token", token);
	        }catch (AuthenticationException authExc){
	            throw new UsuarioNotFoundException();
	        }
	    }
	    
	    /**
		 * Metodo handler de exception de usuarion o encontrado
		 * @param ex excepción lanzada
		 * @return la excepción modificada por nosotros
		 */
	    @ExceptionHandler(UsuarioNotFoundException.class)
		public ResponseEntity<ErroresManager> handleUsuarioNoEncontrado(UsuarioNotFoundException ex) {
			ErroresManager apiError = new ErroresManager();
			apiError.setEstadoPeticion(HttpStatus.BAD_REQUEST);
			apiError.setFecha(LocalDateTime.now());
			apiError.setMensajeDeError(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
		}
	    
	    /**
		 * Metodo handler de exception de usuarion ya existente
		 * @param ex excepción lanzada
		 * @return la excepción modificada por nosotros
		 */
	    @ExceptionHandler(UsuarioExistenteException.class)
		public ResponseEntity<ErroresManager> handleUsuarioNoEncontrado(UsuarioExistenteException ex) {
			ErroresManager apiError = new ErroresManager();
			apiError.setEstadoPeticion(HttpStatus.BAD_REQUEST);
			apiError.setFecha(LocalDateTime.now());
			apiError.setMensajeDeError(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
		}
	    
	    /**
	     * Metodo para obtener un usuario mediante el token de autenticación
	     * @return El usuario al que pertenece el token de la cabecera de la petición
	     */
	    @GetMapping("/user")
	    public User getUser(){ 	
	        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        return repository.findById(userName).get();
	    }
	    
	    /**
	     * Metodo para realizar un put y modificar un usuario
	     * @param userModificar Usuario con los nuevos datos
	     * @return El usuario modificado
	     */
	    @PutMapping("/user/{userName}")
	    public User putUser(@RequestBody User userModificar){
	        return this.servicioUser.editUsuario(userModificar);
	    }
	    
}
