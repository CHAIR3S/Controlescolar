package com.utng.controlescolar.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CicloDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String clave;
	
	private String ciclo;
	
	private Integer periodo;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private Integer estatus;

}
