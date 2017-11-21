package com.irsoticket.backjava.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.irsoticket.backjava.dto.UsuarioDto;

@Entity
@Table(name = "usuarios")
public class Usuario {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String pass;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@Column
	private int rol;

	@Column
	private int cargo;

	@Column(nullable = false)
	private String direccion;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "localidad", nullable = false)
	private Localidad localidad;

	@Column(nullable = false)
	private String mail;

	@Column(nullable = false)
	private String telefono;

	@Column(nullable = false)
	// @Range(max=5, min=3)
	private int horario;

	// -----------------
	// Getters y Setters
	// -----------------

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

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
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

	// DTOs
	public static UsuarioDto toDto(Usuario u) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setId(u.getId());
		usuarioDto.setApellido(u.getApellido());
		usuarioDto.setCargo(u.getCargo());
		usuarioDto.setDireccion(u.getDireccion());
		usuarioDto.setHorario(u.getHorario());
		usuarioDto.setLocalidadObjeto(Localidad.toDto(u.getLocalidad()));
		usuarioDto.setLocalidad(u.getLocalidad().getId());
		usuarioDto.setMail(u.getMail());
		usuarioDto.setNombre(u.getNombre());
		usuarioDto.setPass(u.getPass());
		usuarioDto.setRol(u.getRol());
		usuarioDto.setTelefono(u.getTelefono());

		return usuarioDto;
	}

	// Iterable de usuarios DTO para el get de findAll
	public static Iterable<UsuarioDto> toDto(Iterable<Usuario> usuarios) {
		Collection<UsuarioDto> usuariosDto = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			usuariosDto.add(toDto(usuario));
		}

		return usuariosDto;
	}

	public static Usuario toEntity(UsuarioDto u, Localidad l) {
		Usuario usuario = new Usuario();
		usuario.setId(u.getId());
		usuario.setApellido(u.getApellido());
		usuario.setCargo(u.getCargo());
		usuario.setDireccion(u.getDireccion());
		usuario.setHorario(u.getHorario());
		if (u.getLocalidadObjeto() != null) {
			usuario.setLocalidad(Localidad.toEntity(u.getLocalidadObjeto()));
		}else {
			usuario.setLocalidad(l);
		}			
		usuario.setMail(u.getMail());
		usuario.setNombre(u.getNombre());
		usuario.setPass(u.getPass());
		usuario.setRol(u.getRol());
		usuario.setTelefono(u.getTelefono());

		return usuario;
	}

	public static Iterable<Usuario> toEntity(Iterable<UsuarioDto> usuariosDto) {
		Collection<Usuario> usuarios = new ArrayList<>();
		for (UsuarioDto usuario : usuariosDto) {
			usuarios.add(toEntity(usuario, null));
		}

		return usuarios;
	}

}
