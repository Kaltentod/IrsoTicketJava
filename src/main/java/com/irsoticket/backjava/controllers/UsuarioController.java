package com.irsoticket.backjava.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irsoticket.backjava.dto.UsuarioDto;
import com.irsoticket.backjava.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//Traer todos los usuarios
	@GetMapping
	public Iterable<UsuarioDto> findAll(){
		
		return usuarioService.findAll();
	} 
	
	//Traer un usuario puntual
	@GetMapping("/{id}")
	public UsuarioDto traerUsuario(@PathVariable long id){
			
		return usuarioService.traerUsuario(id);
	} 
	
	//Insertar un nuevo usuario
	@PostMapping
	public UsuarioDto altaUsuario(@RequestBody @Valid UsuarioDto usuario){
		return usuarioService.altaUsuario(usuario);
	}
	
	//Modificar un usuario
	@PutMapping("/{id}")
	public UsuarioDto modificarUsuario(@PathVariable long id,@RequestBody @Valid UsuarioDto usuario){
		return usuarioService.modificarUsuario(id, usuario);
	}
	
	//Borrar un usuario
	@DeleteMapping("/{id}")
	public void borrarUsuario(@PathVariable long id) {
		 usuarioService.borrarUsuario(id);
	}
}