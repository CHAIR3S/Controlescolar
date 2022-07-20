package com.utng.controlescolar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MASTER_TBL_ALUMNO")
public class Alumno implements Serializable{
	private static final long serialVersionUID = -1583460689462715838L; // Se usa para evitar errores al momento 
	 //de volver a cargar una info que al cerrarse se actualizó
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "ID_ALUMNO")
	private Integer id;
	
	@Column(name = "TXT_EXPEDIENTE")
	private String expediente;
	
	@Column(name = "TXT_NOMBRE")
	private String nombre;
	
	@Column(name = "TXT_APE_PATERNO")
	private String apePaterno;
	
	@Column(name = "TXT_APE_MATERNO")
	private String apeMaterno;
	
	@Column(name = "TXT_CURP")
	private String curp;
	
	@Column(name = "TXT_SEXO")
	private String genero;
	
	@Column(name = "TXT_CORREO")
	private String correo;
	
//	@Lob
//	@Column(name = "PHO_FOTO", nullable = false)
//	private Byte[] image;
	
	@ManyToOne(fetch= FetchType.EAGER)  // Primero dice que puede haber muchos alumnos para un solo estatus. La Foreing Key EAGER hace que al llamar al ciclo, cargue todo su contenido
	@JoinColumn(name = "FK_STATUS") //Liga la columna con el FK_STATUS, que es  la FK
	private Estatus estatus; // Variable de tipo estatus
	
	@ManyToOne(fetch= FetchType.EAGER)  // Primero dice que puede haber muchos alumnos para un solo grupo. La Foreing Key EAGER hace que al llamar al grupo, cargue todo su contenido
	@JoinColumn(name = "FK_GRUPO") //Liga la columna con el FK_GRUPO, que es  la FK
	private Grupo grupo; // Variable de tipo grupo
}

