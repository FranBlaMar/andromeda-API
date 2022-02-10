package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Noticia;
import com.example.demo.repository.NoticiaRepository;

/**
 * Clase servicio para gestionar la lógica de negocio de las noticias
 * @author usuario
 *
 */
@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository repositorio;
	
	
	
	
	/**
	 * Metodo para obtener todas las noticias de la base de datos
	 * @return Lista con las noticias de la base de datos
	 */
	public List<Noticia> findAll(){
		return this.repositorio.findAll();
	}
	
	
	/**
	 * Metodo para obtener una noticia mediante su id
	 * @param idNoticia Id de la noticia que se busca
	 * @return La noticia obtenida mediante el id
	 */
	public Noticia findById(Long idNoticia){
		return this.repositorio.findById(idNoticia).get();
	}
	
	
}
