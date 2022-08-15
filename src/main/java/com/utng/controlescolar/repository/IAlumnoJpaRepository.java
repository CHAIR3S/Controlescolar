package com.utng.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.dto.AlumnoDTO;
import com.utng.controlescolar.dto.AlumnoFiltroDTO;
import com.utng.controlescolar.model.Alumno;

@Repository
public interface IAlumnoJpaRepository extends JpaRepository<Alumno, Integer> {
	
//	ResponseGC<Alumno> consultarAlumnoFiltro(AlumnoFiltroDTO filtro);
	
//	ResponseGC<Alumno> SemiActualizarAlumno(AlumnoDTO alumnoDtoUpdate, Alumno alumno);
	
	List<Alumno> findByExpediente(String expediente);
}
