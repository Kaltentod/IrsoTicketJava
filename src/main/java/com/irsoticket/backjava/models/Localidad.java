package com.irsoticket.backjava.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="localidades")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class Localidad {
	
	//Atributos
	@Id 
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	@NotBlank
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
	private Set<Usuario> usuario = new HashSet<>();
	
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
