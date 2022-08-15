package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CalificacionFiltroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer alumno;
	private Integer materia;

}
