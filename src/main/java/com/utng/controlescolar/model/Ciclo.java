package com.utng.controlescolar.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "MASTER_TBL_CICLO_ESCOLAR")
public class Ciclo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key
	
	@Column(name = "PK_CICLO")
	private Integer id;
	
	@Column(name = "TXT_CLAVE")
	private String clave;
	
	@Column(name = "TXT_DESC_CICLO")
	private String ciclo;
	
	@ManyToOne(fetch= FetchType.EAGER)  // Primero dice que puede haber muchos alumnos para un solo estatus. La Foreing Key EAGER hace que al llamar al periodo, cargue todo su contenido
	@JoinColumn(name = "FK_PERIODO") //Liga la columna con el FK_PERIODO, que es  la FK
	private Periodo periodo;
	
	@Column(name = "DAT_FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "DAT_FECHA_FIN")
	private Date fechaFin;
	
	@ManyToOne(fetch= FetchType.EAGER)  // Primero dice que puede haber muchos alumnos para un solo estatus. La Foreing Key EAGER hace que al llamar al ciclo, cargue todo su contenido
	@JoinColumn(name = "FK_STATUS") //Liga la columna con el FK_STATUS, que es  la FK
	private Estatus estatus;
}
