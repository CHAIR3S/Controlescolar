package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CalificacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cal1;
	private Integer cal2;
	private Integer cal3;
	private Integer alumno;
	private Integer materia;

}
