package com.utng.controlescolar.repository;

import com.utng.controlescolar.dto.AlumnoDTO;
import com.utng.controlescolar.dto.AlumnoFiltroDTO;
import com.utng.controlescolar.model.Alumno;

public interface IConsultaAlumnoRepository {
	
	ResponseGC<Alumno> consultarAlumnoFiltro(AlumnoFiltroDTO filtro);

	ResponseGC<Alumno> actualizarAlumno(AlumnoDTO alumnoDtoUpdate, AlumnoFiltroDTO filtro);
	
}
