package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApartadoNotFoundException;
import com.example.demo.error.InfoNotFoundException;
import com.example.demo.model.ApartadoWiki;
import com.example.demo.model.InfoWiki;
import com.example.demo.service.WikiService;

/**
 * Controller donde gestionar las peticiones a la wiki
 * @author usuario
 *
 */

@RestController
public class WikiController {

	@Autowired
	private WikiService service;	
	
	/**
	 * Metodo para devolver todos los apartados 
	 * @return Lista de todos los apartados
	 */
	@GetMapping("/wiki")
	public List<ApartadoWiki> findAllApartados(){
		return this.service.findAllApartados();
	}
	
	/**
	 * Metodo para obtener toda la información de un apartado
	 * @param nombreApartado
	 * @return Toda la info del apartado
	 */
	@GetMapping("/wiki/{nombreApartado}/informacion")
	public List<InfoWiki> getInfoApartado(@PathVariable String nombreApartado){
		ApartadoWiki apartado = this.service.findApartadoByNombre(nombreApartado);
		if(apartado == null) {
			throw new ApartadoNotFoundException(nombreApartado);
		}
		return this.service.findAllInfo(nombreApartado);
	}
	
	
	/**
	 * Metodo para obtener info de un apartado mediante un nombre de busqueda
	 * @param nombreApartado
	 * @param nombreInfo
	 * @return Informacion buscada
	 */
	@GetMapping("/wiki/{nombreApartado}/informacion/{nombreInfo}")
	public InfoWiki getInfoDeApartadoPorNombre(@PathVariable String nombreApartado, @PathVariable String nombreInfo) {
		ApartadoWiki apartado = this.service.findApartadoByNombre(nombreApartado);
		if(apartado == null) {
			throw new ApartadoNotFoundException(nombreApartado);
		}
		InfoWiki info = this.service.findInfoByNombre(nombreApartado, nombreInfo);
		if(info == null) {
			throw new InfoNotFoundException(nombreInfo);
		}
		return info;
	}
	
}
