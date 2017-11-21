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

import com.irsoticket.backjava.dto.LocalidadDto;
import com.irsoticket.backjava.services.LocalidadService;

@RestController
@RequestMapping("/localidad")
public class LocalidadControler {

	@Autowired
	private LocalidadService localidadService;

	//Traer todos los usuarios
	@GetMapping
	public Iterable<LocalidadDto> findAll() {

		return localidadService.findAll();
	}

	// Traer un usuario puntual
	@GetMapping("/{id}")
	public LocalidadDto traerLocalidad(@PathVariable long id) {

		return localidadService.traerLocalidad(id);
	}

	// Insertar un nuevo usuario
	@PostMapping
	public LocalidadDto altaLocalidad(@RequestBody @Valid LocalidadDto localidad) {
		return localidadService.altaLocalidad(localidad);
	}

	// Modificar un usuario
	@PutMapping("/{id}")
	public LocalidadDto modificarLocalidad(@PathVariable long id, @RequestBody @Valid LocalidadDto localidad) {
		return localidadService.modificarLocalidad(id, localidad);
	}

	// Borrar un usuario
	@DeleteMapping("/{id}")
	public void borrarLocalidad(@PathVariable long id) {
		localidadService.borrarLocalidad(id);
	}

}