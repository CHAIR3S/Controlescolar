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
@Table(name = "REL_TBL_GRUPO_MATERIA")
public class GrupoMateria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key
	
	@Column(name = "PK_GR_MT")
	private Integer id;
	
	@Column(name = "FK_GRUPO")
	private Integer grupo;
	
	@Column(name = "FK_MATERIA")
	private Integer materia;

}
