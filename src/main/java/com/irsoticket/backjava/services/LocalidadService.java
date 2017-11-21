package com.irsoticket.backjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.irsoticket.backjava.dto.LocalidadDto;
import com.irsoticket.backjava.exceptions.BadRequestException;
import com.irsoticket.backjava.exceptions.ResourceNotFoundExceptions;
import com.irsoticket.backjava.models.Localidad;
import com.irsoticket.backjava.repositories.LocalidadRepository;

@Service
public class LocalidadService {

	@Autowired
	private LocalidadRepository localidadRepository;

	// Retorna todas las localidades
	public Iterable<LocalidadDto> findAll() {
		return Localidad.toDto(localidadRepository.findAll());
	}

	// Retorna una localidad puntual
	public LocalidadDto traerLocalidad(long id) {
		Localidad localidad = localidadRepository.findOne(id);

		if (localidad == null) {
			throw new ResourceNotFoundExceptions("La localidad",id);
		}

		return Localidad.toDto(localidad);
	}

	// Alta de nueva localidad
	public LocalidadDto altaLocalidad(LocalidadDto localidad) {
		return Localidad.toDto(localidadRepository.save(Localidad.toEntity(localidad)));
	}

	// Modifica la descripcion de una localidad
	public LocalidadDto modificarLocalidad(long id, LocalidadDto localidad) {
		Localidad localidadMod = localidadRepository.findOne(id);

		if (localidadMod == null) {
			throw new ResourceNotFoundExceptions("La localidad",id);
		}
		else {
			localidadMod.setDescripcion(localidad.getDescripcion());
			localidadMod = localidadRepository.save(localidadMod);
		}

		return Localidad.toDto(localidadMod);
	}

	// Borrar localidad
	public void borrarLocalidad(long id) {
		try {
			localidadRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExceptions("La localidad",id);
		}
	}
}