package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ApartadoWiki;
import com.example.demo.model.InfoWiki;
import com.example.demo.repository.ApartadoWikiRepository;

/**
 * Clase service para la lógica de negocio de la wiki
 * @author usuario
 *
 */
@Service
public class WikiService {

	
	@Autowired
	private ApartadoWikiRepository repositorioApartado;
	
	/**
	 * Metodo para devolver todos los apartados de la wiki que hay en la base de datos
	 * @return Lista con todos los apartados
	 */
	public List<ApartadoWiki> findAllApartados(){
		return this.repositorioApartado.findAll();
	}
	
	
	/**
	 * Metodo para obtener un apartado mediante su nombre
	 * @return Apartado que se ha buscado mediante el nombre
	 */
	public ApartadoWiki findApartadoByNombre(String nombreApartado) {
		return this.repositorioApartado.findByNombre(nombreApartado).get(0);
	}
	

	/**
	 * Metodo para obtener toda la info de un apartado de la wiki
	 * @return Lista con toda la info de un apartado
	 */
	public List<InfoWiki> findAllInfo(String nombreApartado){
		ApartadoWiki apartado = this.repositorioApartado.findByNombre(nombreApartado).get(0);
		return apartado.getInformacion();
	}
	
	
	/**
	 * Metodo para obtener una info de un apartado mediante el nombre de la info
	 * @param nombreApartado
	 * @param nombreInfo
	 * @return La info que se ha buscado
	 */
	public InfoWiki findInfoByNombre(String nombreApartado, String nombreInfo) {
		List<InfoWiki> infoDeApartado = findApartadoByNombre(nombreApartado).getInformacion();
		InfoWiki resultado = null;
		for(InfoWiki info : infoDeApartado) {
			if (info.getNombreInfo().equals(nombreInfo)){
				resultado = info;
			}
		}
		return resultado;
	}
	
}
