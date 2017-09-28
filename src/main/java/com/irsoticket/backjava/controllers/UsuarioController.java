package com.irsoticket.backjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irsoticket.backjava.models.Usuario;
import com.irsoticket.backjava.repositories.UsuarioRepository;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Trae todos los usuarios
	@GetMapping("/findAll")
	public Object findAll(){
		return usuarioRepository.findAll();
	} 
	
	//Inserta un nuevo usuario
	@PostMapping("/altaUsuario")
	public Object altaUsuario(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	//Modificar nuevo usuario
	@PutMapping("/modificarUsuario")
	public Object modificarUsuario(@RequestBody Usuario usuario){
		
		Usuario usuarioMod = usuarioRepository.findOne(usuario.getId());
		
		usuarioMod.setApellido(usuario.getApellido());
		usuarioMod.setNombre(usuario.getNombre());
		usuarioMod.setPass(usuario.getPass());
		usuarioMod.setRol(usuario.getRol());
		
		return usuarioRepository.save(usuarioMod);
	}
	
	//Borrar un usuario
	@DeleteMapping("/borrarUsuario/{id}")
	public Object borrarUsuario(@PathVariable long id)throws MessagingException {
		Usuario usuario = usuarioRepository.findOne(id);
		usuarioRepository.delete(usuario);
		return usuario;
	}
}
