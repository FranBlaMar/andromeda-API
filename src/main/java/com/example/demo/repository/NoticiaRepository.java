package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long>{

}