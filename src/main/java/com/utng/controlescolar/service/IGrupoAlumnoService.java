package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.ProfesorMateria;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface IGrupoAlumnoService {
	
	ResponseGC<ProfesorMateria> ConsultarTodos();

}
