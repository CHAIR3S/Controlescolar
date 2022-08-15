package com.utng.controlescolar.repository;

import org.springframework.stereotype.Repository;

import com.utng.controlescolar.dto.CalificacionDTO;
import com.utng.controlescolar.dto.CalificacionFiltroDTO;
import com.utng.controlescolar.model.Calificacion;

@Repository
public interface IConsultaCalificacionRepository {
	
	ResponseGC<Calificacion> actualizarCalificacion (CalificacionDTO calificacionUpdate, CalificacionFiltroDTO filtro);

}
