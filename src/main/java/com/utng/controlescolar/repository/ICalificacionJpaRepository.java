package com.utng.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar.model.Calificacion;

public interface ICalificacionJpaRepository extends JpaRepository <Calificacion, Integer>{

	List<Calificacion> findByAlumnoAndMateria(Integer alumno, Integer Materia);
	
}
