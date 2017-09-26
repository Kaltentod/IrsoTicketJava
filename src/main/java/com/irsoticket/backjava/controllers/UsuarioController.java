package com.irsoticket.backjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.irsoticket.backjava.models.Usuario;
import com.irsoticket.backjava.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Trae todos los usuarios
	@GetMapping("/findAll")
	public Object test(){
		return usuarioRepository.findAll();
	} 
	
	//inserta un nuevo usuario
	@PostMapping("/altaUsuario")
	public void altaUsuario(@RequestBody Usuario usuario){
		usuarioRepository.save(usuario);
	}
}
