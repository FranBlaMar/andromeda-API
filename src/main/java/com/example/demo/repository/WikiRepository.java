package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Wiki;

public interface WikiRepository extends JpaRepository<Wiki, Long>{

}
