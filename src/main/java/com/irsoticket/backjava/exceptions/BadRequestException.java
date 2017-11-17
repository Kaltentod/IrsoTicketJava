package com.irsoticket.backjava.exceptions;

public class BadRequestException extends RuntimeException {
	
	private String mensaje; 
	
	public BadRequestException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
