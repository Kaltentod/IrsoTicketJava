package com.irsoticket.backjava.dto;

public class ErrorInfo {

	private String mensaje, codigo;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ErrorInfo(String mensaje, String codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
		
}