package com.irsoticket.backjava.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irsoticket.backjava.models.Usuario;
import com.irsoticket.backjava.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Trae todos los usuarios
	@GetMapping
	public Object findAll(){
		return usuarioRepository.findAll();
	} 
	
	//Inserta un nuevo usuario
	@PostMapping
	public Usuario altaUsuario(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	//Modificar un usuario
	@PutMapping("/{id}")
	public Usuario modificarUsuario(@PathVariable long id,@RequestBody Usuario usuario){
		
		Usuario usuarioMod = usuarioRepository.findOne(id);
		
		usuarioMod.setApellido(usuario.getApellido());
		usuarioMod.setNombre(usuario.getNombre());
		usuarioMod.setPass(usuario.getPass());
		usuarioMod.setRol(usuario.getRol());
		
		return usuarioRepository.save(usuarioMod);
	}
	
	//Borrar un usuario
	@DeleteMapping("/{id}")
	public Usuario borrarUsuario(@PathVariable long id) {
		Usuario usuario = usuarioRepository.findOne(id);
		usuarioRepository.delete(usuario);
		return usuario;
	}
}
