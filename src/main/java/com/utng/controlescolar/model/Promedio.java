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
@Table(name = "CAT_TBL_ROL") //llamamos la tabla de la base de datos
public class Promedio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "PK_PROMEDIO")
	private Integer id;
	
	@Column(name = "NUM_CAL_1")
	private Integer cal1;
	
	@Column(name = "NUM_CAL_2")
	private Integer cal2;
	
	@Column(name = "NUM_CAL_3")
	private Integer cal3;
	
	@Column(name = "NUM_PROMEDIO")
	private double promedio;
	
	

}
