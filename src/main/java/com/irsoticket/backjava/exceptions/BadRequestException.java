package com.irsoticket.backjava.exceptions;

public class BadRequestException extends Exception {
	
	private String mensaje; 
	
	public BadRequestException(String mensaje){
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
