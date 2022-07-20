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
@Table(name = "MASTER_TBL_GRUPO")
public class Grupo implements Serializable {
	private static final long serialVersionUID = -1583460689462715838L; // Se usa para evitar errores al momento
	// de volver a cargar una info que al cerrarse se actualizó, así como para no revolver toda la ifo, no es necesaria
	// pero sí recomendable
	// poner en todas las clases que heredan serializable

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Que va incrementando automáticamente cada primary key

	@Column(name = "PK_GRUPO")
	private Integer id;

	@Column(name = "TXT_DESC_GRUPO")
	private String grupo;

	@ManyToOne(fetch= FetchType.EAGER)  // Primero dice que puede haber muchos alumnos para un solo estatus. La Foreing Key EAGER hace que al llamar al ciclo, cargue todo su contenido
	@JoinColumn(name = "FK_STATUS") //Liga la columna con el FK_STATUS, que es  la FK
	private Estatus estatus;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CICLO")
	private Ciclo ciclo;

}
