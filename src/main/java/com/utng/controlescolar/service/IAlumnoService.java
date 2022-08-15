package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.AlumnoDTO;
import com.utng.controlescolar.dto.AlumnoFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface IAlumnoService {
	
	ResponseGC<Alumno> ConsultarTodos();
	
	ResponseGC<Alumno> GuardarAlumno(AlumnoDTO alumnoDto);
	
	ResponseGC<Alumno> BorrarAlumnoId(Integer idAlumno);
	
	ResponseGC<Alumno> BuscarAlumno(AlumnoFiltroDTO filtro);

	ResponseGC<Alumno> ActualizarAlumno(AlumnoDTO alumnoDtoUpdate, AlumnoFiltroDTO filtro);
	
	ResponseGC<Alumno> BuscarAlumnoId(Integer idAlumno);

}
