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
@Table(name = "CAT_TBL_STATUS") //llamamos la tabla de la base de datos
public class Estatus implements Serializable {
	
	private static final long serialVersionUID = -6294468319997277393L;

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "PK_STATUS")
	private Integer id;
	
	@Column(name= "TXT_STATUS")
	private String estatus;
	
}
