package com.irsoticket.backjava.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException{
	
	private String mensaje; 
	
	public ResourceNotFoundExceptions(long id){
		this.mensaje = "El usuario ingresado con id="+id+" no existe";
	}

	public String getMensaje() {
		return mensaje;
	}

}