package com.utng.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.dto.AlumnoDTO;
import com.utng.controlescolar.dto.AlumnoFiltroDTO;
import com.utng.controlescolar.model.Alumno;

@Repository
public interface IAlumnoJpaRepository extends JpaRepository<Alumno, Integer> {
	
//	ResponseGC<Alumno> BuscarAlumnoFiltro(AlumnoFiltroDTO filtro);
	
//	ResponseGC<Alumno> SemiActualizarAlumno(AlumnoDTO alumnoDtoUpdate, Alumno alumno);
}
