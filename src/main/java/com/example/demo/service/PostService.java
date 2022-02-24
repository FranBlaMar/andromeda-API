package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;

/**
 * Clase service para la lógica de negocio de los posts
 * @author usuario
 *
 */
@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	@Autowired
	private UsuarioService servicioUsuario;
	
	/**
	 * Método para crear post
	 * @param post nuevo post
	 * @return Post creado
	 */
	public Post crearPost(Post post) {
		User user = post.getAuthor();
		user.setNumberOfPosts(user.getNumberOfPosts()+1);
		this.servicioUsuario.editUsuario(user);
		return this.repository.save(post);
	}
	
	
	/**
	 * Método para modificar un post de la base de datos
	 * @param post post modificado
	 * @param id id del post que vamos a modificar
	 * @return Post modificado
	 */
	public Post modifyPost(Post post, Long id) {
		post.setId(id);
		return this.repository.save(post);
	}
}
