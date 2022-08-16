package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginFiltroDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo;
	private String contraseña;

}
