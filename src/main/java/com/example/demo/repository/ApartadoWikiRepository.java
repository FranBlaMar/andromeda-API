package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ApartadoWiki;

public interface ApartadoWikiRepository extends JpaRepository<ApartadoWiki, Long>{

	
	@Query("SELECT a FROM ApartadoWiki a WHERE  nombreApartado=:nombre")
	public List<ApartadoWiki> findByNombre(String nombre);
	
}
