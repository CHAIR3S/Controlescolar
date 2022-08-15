package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlumnoFiltroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String expediente;
	private String curp;
	private String correo;

}