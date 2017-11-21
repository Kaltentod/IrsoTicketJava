package com.irsoticket.backjava.dto;

import org.hibernate.validator.constraints.NotBlank;


public class LocalidadDto {
	
	//Atributos
	private long id;
	
	@NotBlank
	private String descripcion;
	
	//Getters y Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
