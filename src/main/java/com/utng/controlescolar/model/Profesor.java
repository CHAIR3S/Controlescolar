package com.utng.controlescolar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "MASTER_TBL_PROFESOR") //llamamos la tabla de la base de datos
public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "PK_PROFESOR")
	private Integer id;
	
	@Column(name = "TXT_CLAVE")
	private String clave;
	
	@Column(name = "TXT_NOMBRE")
	private String nombre;
	
	@Column(name = "TXT_APE_PATERNO")
	private String apePaterno;
	
	@Column(name = "TXT_APE_MATERNO")
	private String apeMaterno;
	
	@Column(name = "TXT_CORREO")
	private String correo;
	
}
