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
	private String nameInfo;
	
	@Column (name="imagen", nullable = false)
	private String image;
	
	@Column(name = "Informacion", nullable = false, length = 5000)
	private String info;
	
	
	public InfoWiki (String nameInfo, String info, String image) {
		this.nameInfo = nameInfo;
		this.info = info;
		this.image = image;
	}
	
	
}
