package com.utng.controlescolar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "REL_TBL_PROF_MAT_GRU") //llamamos la tabla de la base de datos
public class ProMatGru implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "PK_PR_MT_GR")
	private Integer id;
	
	@ManyToOne(fetch= FetchType.EAGER)  
	@JoinColumn(name = "FK_PROFESOR") 
	private Profesor profesor;
	
	@ManyToOne(fetch= FetchType.EAGER)  
	@JoinColumn(name = "FK_MATERIA") 
	private Materia materia;
	
	@ManyToOne(fetch= FetchType.EAGER)  // Primero dice que puede haber muchos alumnos para un solo grupo. La Foreing Key EAGER hace que al llamar al grupo, cargue todo su contenido
	@JoinColumn(name = "FK_GRUPO") //Liga la columna con el FK_GRUPO, que es  la FK
	private Grupo grupo; // Variable de tipo grupo

}
