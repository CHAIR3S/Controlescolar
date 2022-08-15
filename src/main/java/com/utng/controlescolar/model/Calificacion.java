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
@Table(name = "AUX_TBL_CALIFICACIONES") //llamamos la tabla de la base de datos
public class Calificacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "PK_CALIFICACION")
	private Integer id;
	
	@Column(name = "NUM_CAL_UNIDAD_UNO")
	private Integer cal1;
	
	@Column(name = "NUM_CAL_UNIDAD_DOS")
	private Integer cal2;
	
	@Column(name = "NUM_CAL_UNIDAD_TRES")
	private Integer cal3;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_ALUMNO")
	private Alumno alumno;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_MATERIA")
	private Materia materia;

}
