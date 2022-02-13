package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Clase informacion de la wikipedia
 * @author usuario
 *
 */
@Entity
@Table(name = "InformacionWiki")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class InfoWiki {

	@Id
	private String nombreInfo;
	
	@Column (name="imagen", nullable = false)
	private String imagen;
	
	@Column(name = "Informacion", nullable = false, length = 5000)
	private String informacion;
	
	
	public InfoWiki (String nombreInfo, String informacion, String imagen) {
		this.nombreInfo = nombreInfo;
		this.informacion = informacion;
		this.imagen = imagen;
	}

	public InfoWiki() {
		
	}

	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setNombreInfo(String nombreInfo) {
		this.nombreInfo = nombreInfo;
	}

	public String getInformacion() {
		return informacion;
	}


	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}


	public String getNombreInfo() {
		return nombreInfo;
	}
	
	
}
