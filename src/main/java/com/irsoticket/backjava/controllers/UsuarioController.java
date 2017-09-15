package com.irsoticket.backjava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irsoticket.backjava.models.Usuario;

@RestController
public class UsuarioController {
	
	@GetMapping("/Usuario")
	public Usuario test(){
		Usuario pablito = new Usuario();
		pablito.setNombre("Pablito Miranda");
		return pablito;
	} 

}
