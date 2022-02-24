package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;

/**
 * Controller donde gestionar las peticiones a la clase post
 * @author usuario
 *
 */
@RestController
public class PostController {

	@Autowired
	private PostRepository repositorio;
	@Autowired
	private PostService servicio;
	
	/**
	 * Método para obtener todos los posts de la base de datos
	 * @return Lista con todos los posts
	 */
	@GetMapping("/post")
	public List<Post> getPosts() {
		return this.repositorio.findAll();
	}
	
	/**
	 * Método para crear un nuevo post en la base de datos 
	 * @param postNuevo
	 * @return Post guardado en la base de datos
	 */
	@PostMapping("/post")
	public Post setPost(@RequestBody Post postNuevo) {
		return this.servicio.crearPost(postNuevo);
	}
	
	/**
	 * Método para obtener un post por su id
	 * @param id
	 * @return Post obtenido mediante su id
	 */
	@GetMapping("/post/{idPost}")
	public Post getPostById(@RequestParam Long id) {
		return this.repositorio.findById(id).get();
	}
	
	
	/**
	 * Método para modificar un post en la base de datos
	 * @param postModify Post modificado
	 * @param idPost Id del post que vamos a modificar
	 * @return Post modificado
	 */
	@PutMapping("/post/{idPost}")
	public Post modifyPost(@RequestBody Post postModify, @RequestParam Long idPost) {
		return this.servicio.modifyPost(postModify, idPost);
	}

}
