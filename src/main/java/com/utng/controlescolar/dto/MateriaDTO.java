package com.utng.controlescolar.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class MateriaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String clave;
	private String nombre;
	// El id de estatus
	private Integer estatus;
	//El id de ciclo
	private Integer ciclo;
}
