package com.irsoticket.backjava.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException{
	
	private String mensaje; 
	
	public ResourceNotFoundExceptions(String m,long id){
		this.mensaje = m+" que se ingreso con id="+id+" no existe";
	}

	public String getMensaje() {
		return mensaje;
	}

}