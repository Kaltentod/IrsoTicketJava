package com.irsoticket.backjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.irsoticket.backjava.dto.UsuarioDto;
import com.irsoticket.backjava.exceptions.BadRequestException;
import com.irsoticket.backjava.exceptions.ResourceNotFoundExceptions;
import com.irsoticket.backjava.models.Localidad;
import com.irsoticket.backjava.models.Usuario;
import com.irsoticket.backjava.repositories.LocalidadRepository;
import com.irsoticket.backjava.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private LocalidadRepository localidadRepository;

	// Retorna todos los usuarios
	public Iterable<UsuarioDto> findAll() {
		return Usuario.toDto(usuarioRepository.findAll());
	}

	// Retorna un usuario puntual
	public UsuarioDto traerUsuario(long id) {
		Usuario usuario = usuarioRepository.findOne(id);

		if (usuario == null) {
			throw new ResourceNotFoundExceptions("El usuario",id);
		}

		return Usuario.toDto(usuario);
	}

	// Alta de nuevo usuario
	public UsuarioDto altaUsuario(UsuarioDto usuario) {

		Localidad localidadMod = getLocalidad(usuario);
		return Usuario.toDto(usuarioRepository.save(Usuario.toEntity(usuario, localidadMod)));
	}

	// Modificacion de usuario
	public UsuarioDto modificarUsuario(long id, UsuarioDto usuario) {
		Usuario usuarioMod = usuarioRepository.findOne(id);

		if (usuarioMod != null) {
			usuarioMod.setApellido(usuario.getApellido());
			usuarioMod.setNombre(usuario.getNombre());
			usuarioMod.setPass(usuario.getPass());
			usuarioMod.setRol(usuario.getRol());
			usuarioMod.setCargo(usuario.getCargo());
			usuarioMod.setDireccion(usuario.getDireccion());

			Localidad localidadMod = getLocalidad(usuario);

			usuarioMod.setLocalidad(localidadMod);
			usuarioMod.setMail(usuario.getMail());
			usuarioMod.setTelefono(usuario.getTelefono());
			usuarioMod.setHorario(usuario.getHorario());
			usuarioMod = usuarioRepository.save(usuarioMod);
		} else {
			throw new ResourceNotFoundExceptions("El usuario",id);
		}

		return Usuario.toDto(usuarioMod);
	}

	private Localidad getLocalidad(UsuarioDto usuario) {
		Localidad localidadMod = localidadRepository.findOne(usuario.getLocalidad());

		if (localidadMod == null) {
			throw new BadRequestException("La localidad: " + usuario.getLocalidad() + " no existe");
		}
		return localidadMod;
	}

	// Borrar usuario
	public void borrarUsuario(long id) {
		try {
			usuarioRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExceptions("El usuario",id);
		}
	}

}