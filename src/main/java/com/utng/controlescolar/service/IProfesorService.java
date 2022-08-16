package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface IProfesorService {
	
	ResponseGC<Profesor> ConsultarTodos();
	
	ResponseGC<Profesor> BuscarProfesorClave (String clave);

}
