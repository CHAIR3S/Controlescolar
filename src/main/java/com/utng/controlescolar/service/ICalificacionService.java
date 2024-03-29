package com.utng.controlescolar.service;

import com.utng.controlescolar.dto.CalificacionAndFiltroDTO;
import com.utng.controlescolar.dto.CalificacionDTO;
import com.utng.controlescolar.model.Calificacion;
import com.utng.controlescolar.repository.ResponseGC;

public interface ICalificacionService {
	
	ResponseGC<Calificacion> ConsultarTodos();
	
	ResponseGC<Calificacion> GuardarCalificacion(CalificacionDTO calificacion);
	
	ResponseGC<Calificacion> BorrarCalificacionId(Integer idCalificacion);
	
	ResponseGC<Calificacion> BuscarCalificacionAlumno (Integer alumno);

	ResponseGC<Calificacion> ActualizarCalificacion(CalificacionAndFiltroDTO upToDate);
	
	ResponseGC<Calificacion> BuscarCalificacionId(Integer idCalificacion);

}
