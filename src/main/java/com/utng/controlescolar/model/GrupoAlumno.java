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

@Getter
@Setter
@Entity
@Table(name = "TBL_GRUPO_ALUMNO")
public class GrupoAlumno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key
	
	@Column(name = "ID_GR_AL")
	private Integer grupoAlumno;
	
	@Column(name = "ID_GRUPO")
	private Integer grupo;
	
	@Column(name = "ID_ALUMNO")
	private Integer alumno;

}
