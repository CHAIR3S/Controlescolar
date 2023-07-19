package com.utng.controlescolar.model;



public class JwtRequest {
	
	private String correo;
	private String contraseña;

	public JwtRequest(String correo, String contraseña) {
		this.correo = correo;
		this.contraseña = contraseña;
	}

	public JwtRequest() {
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
	
}
