package com.example.demo.error;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;


@Getter
@Setter
public class ErroresManager {
	
	private HttpStatus estadoPeticion;
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime fecha;
	private String mensajeDeError;
}
