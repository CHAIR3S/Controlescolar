package com.utng.controlescolar.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MateriaAndFiltroDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MateriaFiltroDTO filtro;
	private MateriaDTO MateriaUpdate;

}
