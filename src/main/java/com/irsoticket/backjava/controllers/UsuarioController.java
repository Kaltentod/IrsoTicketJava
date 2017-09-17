package com.irsoticket.backjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irsoticket.backjava.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@GetMapping("/Usuario")
	public Object test(){
		return usuarioRepository.findAll();
	} 

}
