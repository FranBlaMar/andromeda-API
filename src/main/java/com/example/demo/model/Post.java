package com.example.demo.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase de post
 * @author usuario
 *
 */
@Entity
@Table(name = "Post")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="title", nullable = false, length = 100)
	private String title;
	
	@Column (name="body", nullable = false,length = 5000)
	private String body;
	
	@ManyToOne
	@JoinColumn(name="user_post")
	private User author;
	
	@Column (name="date", nullable = false)
	private LocalDate date = LocalDate.now();

	public Post (String title, String body, User author) {
		this.title = title;
		this.body = body;
		this.author = author;
	}
}

