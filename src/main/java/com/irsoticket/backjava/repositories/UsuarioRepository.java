package com.irsoticket.backjava.repositories;

import org.springframework.data.repository.CrudRepository;

import com.irsoticket.backjava.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
}
