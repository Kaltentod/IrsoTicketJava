package com.irsoticket.backjava.dto;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonGetter;

public class UsuarioDto {
	
	//Atributos
	private long id;
	
	
	@NotBlank
	private String pass;

	
	@NotBlank
	private String nombre;
	
	
	@NotBlank
	private String apellido;
	
	
	private int rol;
	
	
	private int cargo;
	
	
	private LocalidadDto localidadObjeto;
	

	@NotBlank
	private String direccion;
	
	private long localidad;
	
	
	@NotBlank
	private String mail;
	
	
	@NotBlank
	private String telefono;
	
	
	//@Range(max=5, min=3)
	private int horario;

	//-----------------
	//Getters y Setters
	//-----------------
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public long getLocalidad() {
		return localidad;
	}

	public void setLocalidad(long localidad) {
		this.localidad = localidad;
	}
	
	@JsonGetter("localidad")
	public LocalidadDto getLocalidadObjeto() {
		return localidadObjeto;
	}
	
	
	public void setLocalidadObjeto(LocalidadDto localidadObjeto) {
		this.localidadObjeto = localidadObjeto;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

}
