package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlumnoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String expediente;
	private String nombre;
	private String curp;
	private String genero;
	private String correo;
	private String estatus;
	// id de ciclo
	private Integer ciclo;
}
