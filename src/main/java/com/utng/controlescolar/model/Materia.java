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

@Setter
@Getter
@Entity
@Table(name = "MASTER_TBL_MATERIA") //llamamos la tabla de la base de datos
public class Materia implements Serializable{
	
	private static final long serialVersionUID = -6294468319997277393L;

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "PK_MATERIA")
	private Integer id;
	
	@Column(name = "TXT_CLAVE")
	private String clave;
	
	@Column(name = "DES_MATERIA")
	private String nombre;
	
	@ManyToOne(fetch= FetchType.EAGER)  // Primero dice que puede haber muchos alumnos para un solo estatus. La Foreing Key EAGER hace que al llamar al ciclo, cargue todo su contenido
	@JoinColumn(name = "FK_STATUS") //Liga la columna con el FK_STATUS, que es  la FK
	private Estatus estatus;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_CICLO")
	private Ciclo ciclo;
}
