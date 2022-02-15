package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
	public Noticia findAllById(@PathVariable Long idNoticia){
		return this.servicie.findById(idNoticia);
	}
	
}
