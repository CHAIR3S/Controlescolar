package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.GrupoAlumno;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface IGrupoAlumnoService {
	
	ResponseGC<GrupoAlumno> ConsultarTodos();

}
