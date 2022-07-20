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
@Table(name = "MASTER_TBL_LOGIN") //llamamos la tabla de la base de datos
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "PK_LOGIN")
	private Integer id;
	
	@Column(name = "TXT_CORREO")
	private String correo;
	
	@Column(name = "TXT_PASSWORD")
	private String contraseña;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_ROL")
	private Rol rol;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_PROFESOR")
	private Profesor profesor;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_ALUMNO")
	private Alumno alumno;
	
}
