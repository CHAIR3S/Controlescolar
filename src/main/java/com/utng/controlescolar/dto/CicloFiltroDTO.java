package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CicloFiltroDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String clave;
	private String ciclo;

}
