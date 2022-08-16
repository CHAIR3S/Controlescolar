package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CalificacionAndFiltroDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CalificacionDTO calificacionUpdate;
	
	private CalificacionFiltroDTO filtro;

}
