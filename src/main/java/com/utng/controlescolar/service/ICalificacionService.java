package com.utng.controlescolar.service;

import com.utng.controlescolar.dto.CalificacionDTO;
import com.utng.controlescolar.dto.CalificacionFiltroDTO;
import com.utng.controlescolar.model.Calificacion;
import com.utng.controlescolar.repository.ResponseGC;

public interface ICalificacionService {
	
	ResponseGC<Calificacion> ConsultarTodos();
	
	ResponseGC<Calificacion> GuardarCalificacion(CalificacionDTO calificacion);
	
	ResponseGC<Calificacion> BorrarCalificacionId(Integer idCalificacion);
	
	ResponseGC<Calificacion> BuscarCalificacionMateriaAlumno (Integer alumno, Integer materia);

	ResponseGC<Calificacion> ActualizarCalificacion(CalificacionDTO calificacionUpdate, CalificacionFiltroDTO filtro);
	
	ResponseGC<Calificacion> BuscarCalificacionId(Integer idCalificacion);

}
