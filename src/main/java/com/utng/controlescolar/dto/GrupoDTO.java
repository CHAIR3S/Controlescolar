package com.utng.controlescolar.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class GrupoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String grupo;
	private String estatus;
	private Integer ciclo;
}
