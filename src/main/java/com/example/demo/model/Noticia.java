package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Clase noticia
 * @author usuario
 *
 */
@Entity
@Table(name = "Noticia")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNoticia;
	@Column(name="titular", nullable = false)
	private String titular;
	@Column(name="imagen", nullable = false)
	private String imagen;
	@Column(name="url", nullable = false)
	private String url;
	
	public Noticia(String imagen,String titular, String url) {
		this.imagen = imagen;
		this.titular = titular;
		this.url = url;
	}
	
	public Noticia() {
		
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
