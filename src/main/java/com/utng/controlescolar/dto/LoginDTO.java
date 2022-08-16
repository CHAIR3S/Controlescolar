package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String correo;
	private String contraseña;
	private Integer rol;
	private Integer profesor;
	private Integer alumno;

}
