package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comentario;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.ComentarioRepository;
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
	private ComentarioRepository repositorioComentario;
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
	
	/**
	 * Metodo para obtener un comentario mediante su id
	 * @param post Post al que pertenece el comentario
	 * @param idComent id del post
	 * @return El post buscado
	 */
	public Comentario obtenerComentarioPorId(Post post, Long idComent) {
		List<Comentario> comentarios = post.getComments();
		Comentario resultado = null;
		for(Comentario c : comentarios) {
			if (c.getIdComment().equals(idComent)) {
				resultado = c;
			}
		}
		return resultado;
	}
	
	
	/**
	 * Método para modificar un comentario de la base de datos
	 * @param post post al que pertenece el comentario
	 * @param idComentario id del Comentario que estamos modificando
	 * @param comentarioModificado Comentario ya modificado
	 * @return Comentario modificado
	 */
	public Comentario modifyComentario(Post post,Long idComentario,  Comentario comentarioModificado) {
		comentarioModificado.setIdComment(idComentario);
		post.addComentario(comentarioModificado);
		this.repository.save(post);
		return comentarioModificado;
	}
	
	/**
	 * Metodo para eliminar un comentario
	 * @param comentarioAEliminar Comentario que deseamos eliminar
	 * @return Comentario Eliminado
	 */
	public Comentario eliminarComentario(Post post, Comentario comentarioAEliminar) {
		post.getComments().remove(comentarioAEliminar);
		User user = comentarioAEliminar.getAuthor();
		user.setNumberOfComents(user.getNumberOfComents()-1);
		this.servicioUsuario.editUsuario(user);
		this.repository.save(post);
		return comentarioAEliminar;
	}
	
	
	/**
	 * Metodo para crear un comentario
	 * @param post Post al que añadimos el comentario
	 * @param comentarioAAñadir comentario que queremos añadir
	 * @return El comentario añadido
	 */
	public Comentario crearComentario(Post post, Comentario comentarioNuevo) {
		post.addComentario(comentarioNuevo);
		User user = comentarioNuevo.getAuthor();
		user.setNumberOfComents(user.getNumberOfComents()+1);
		this.servicioUsuario.editUsuario(user);
		this.repository.save(post);
		return comentarioNuevo;
	}
}

