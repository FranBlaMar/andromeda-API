package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase usuario
 * @author usuario
 *
 */
@Entity
@Table(name = "Usuario")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	
	@Id
	private String userName;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Column (name="email", nullable = false)
	private String email;
	
	@Column (name="nombre", nullable = false)
	private String name;
	
	@Column (name="descripcion")
	private String aboutMe;
	
	@Column (name="numero_de_posts")
	private int numberOfPosts;
	
	@Column (name="numero_de_comentarios")
	private int numberOfComents;
	
	public User(String userName,String password, String email, String name, String aboutMe){
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
		this.aboutMe = aboutMe;
		this.numberOfPosts = 0;
		this.numberOfComents = 0;
	}
	
}
