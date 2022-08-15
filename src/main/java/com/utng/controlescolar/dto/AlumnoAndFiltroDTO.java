package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlumnoAndFiltroDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AlumnoDTO alumnoUpdate;
	private AlumnoFiltroDTO filtro;
		
}
