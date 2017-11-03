package com.irsoticket.backjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.irsoticket.backjava.exceptions.ResourceNotFoundExceptions;
import com.irsoticket.backjava.models.Usuario;
import com.irsoticket.backjava.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Retorna todos los usuarios
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	//Retorna un usuario puntual
	public Usuario traerUsuario(long id) {
		Usuario usuario = usuarioRepository.findOne(id);
		
		if (usuario==null) {
			throw new ResourceNotFoundExceptions(id);
		}
		
		return usuario;
	}
	
	//Alta de nuevo usuario
	public Usuario altaUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	//Modificacion de usuario
	public Usuario modificarUsuario(long id, Usuario usuario) {
		Usuario usuarioMod = usuarioRepository.findOne(id);
		
		if (usuarioMod!=null) {
			usuarioMod.setApellido(usuario.getApellido());
			usuarioMod.setNombre(usuario.getNombre());
			usuarioMod.setPass(usuario.getPass());
			usuarioMod.setRol(usuario.getRol());
			usuarioMod.setCargo(usuario.getCargo());
			usuarioMod.setDireccion(usuario.getDireccion());
			usuarioMod.setLocalidad(usuario.getLocalidad());
			usuarioMod.setMail(usuario.getMail());
			usuarioMod.setTelefono(usuario.getTelefono());
			usuarioMod.setHorario(usuario.getHorario());
			usuarioMod = usuarioRepository.save(usuarioMod);
		}else {
			throw new ResourceNotFoundExceptions(id);
		}
			
		return usuarioMod;
	}

	//Borrar usuario
	public void borrarUsuario(long id) {
		try {
			usuarioRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExceptions(id);
		}
	}
}