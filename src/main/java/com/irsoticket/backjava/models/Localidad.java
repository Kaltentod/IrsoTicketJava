package com.irsoticket.backjava.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irsoticket.backjava.dto.LocalidadDto;


@Entity
@Table(name="localidades")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class Localidad {
	
	//Atributos
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	@NotBlank
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "localidad",fetch = FetchType.LAZY)
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
	
	//DTOs
		public static LocalidadDto toDto(Localidad l) {
			LocalidadDto localidadDto = new LocalidadDto();
			localidadDto.setId(l.getId());
			localidadDto.setDescripcion(l.getDescripcion());
			
			return localidadDto;
		} 
		
		//Iterable de usuarios DTO para el get de findAll
		public static Iterable<LocalidadDto> toDto(Iterable <Localidad> localidades){
			Collection<LocalidadDto> localidadesDto = new ArrayList<>();
			for (Localidad localidad : localidades) {
				localidadesDto.add(toDto(localidad)); 
			}
			
			return localidadesDto;
		}
		
		public static Localidad toEntity(LocalidadDto l) {
			Localidad localidad = new Localidad();
			localidad.setId(l.getId());
			localidad.setDescripcion(l.getDescripcion());

			return localidad;
		} 
		
		public static Iterable<Localidad> toEntity(Iterable <LocalidadDto> localidadDto){
			Collection<Localidad> localidades = new ArrayList<>();
			for (LocalidadDto localidad : localidadDto) {
				localidades.add(toEntity(localidad)); 
			}
			
			return localidades;
		}
}
