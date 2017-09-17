package com.irsoticket.backjava.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuario {
	
	@Id
	private long id;
	
	@Column(name="Nombre")
	private String nombre;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
