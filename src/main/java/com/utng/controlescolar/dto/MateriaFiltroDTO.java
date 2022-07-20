package com.utng.controlescolar.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class MateriaFiltroDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String clave;

}
