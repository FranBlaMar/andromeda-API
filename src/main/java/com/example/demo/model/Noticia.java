package com.example.demo.model;

import java.time.LocalDate;

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
	@Column(name="autor", nullable = false)
	private String autor;
	@Column(name="cuerpo", nullable = false)
	private String cuerpoNoticia;
	@Column(name="fecha", nullable = false)
	private LocalDate fecha;
	
	public Noticia(String titular, String autor, String cuerpoNoticia, LocalDate fecha) {
		this.titular = titular;
		this.autor = autor;
		this.cuerpoNoticia = cuerpoNoticia;
		this.fecha = fecha;
	}
}
