package com.irsoticket.backjava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
	
	@GetMapping
	public String test(){
		return "Hola";
	} 

}
