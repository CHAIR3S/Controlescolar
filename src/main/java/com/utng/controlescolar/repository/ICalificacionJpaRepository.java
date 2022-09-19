package com.utng.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Calificacion;
import com.utng.controlescolar.model.Materia;

public interface ICalificacionJpaRepository extends JpaRepository <Calificacion, Integer>{

	List<Calificacion> findByAlumno(Alumno alumno);
	
	List<Calificacion> findByAlumnoAndMateria(Alumno alumno, Materia materia);
	
}
