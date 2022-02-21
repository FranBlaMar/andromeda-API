package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.error.ErroresManager;
import com.example.demo.error.NoticiaNotFoundException;
import com.example.demo.model.Noticia;
import com.example.demo.service.NoticiaService;

/**
 * Clase controller donde gestionamos las peticiones de noticia
 * @author usuario
 *
 */
@RestController
public class NoticiasController {

	@Autowired
	private NoticiaService servicie;
	
	
	
	/**
	 * Metodo para obtener una noticia
	 * @return Lista con todas las noticias
	 */
	@GetMapping("/noticia")
	public List<Noticia> findAll(){
		return this.servicie.findAll();
	}
	
	/**
	 * Metodo para obtener una noticia mediante su id
	 * @return  La noticia buscada
	 */
	@GetMapping("/noticia/{idNoticia}")
	public Noticia findAllById(@PathVariable Long idNoticia) throws NoticiaNotFoundException{
		Noticia resultado = this.servicie.findById(idNoticia);
		if(resultado == null) {
			throw new NoticiaNotFoundException(idNoticia);
		}
		return resultado;
	}
	
	/**
	 * Metodo handler de exception de nositias no encontradas
	 * @param ex excepción lanzada
	 * @return la excepción modificada por nosotros
	 */
	@ExceptionHandler(NoticiaNotFoundException.class)
	public ResponseEntity<ErroresManager> handleUsuarioNoEncontrado(NoticiaNotFoundException ex) {
		ErroresManager apiError = new ErroresManager();
		apiError.setEstadoPeticion(HttpStatus.NOT_FOUND);
		apiError.setFecha(LocalDateTime.now());
		apiError.setMensajeDeError(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
}
