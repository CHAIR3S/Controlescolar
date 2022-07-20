package com.utng.controlescolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.utng.controlescolar.model.GrupoAlumno;
import com.utng.controlescolar.repository.IGrupoAlumnoJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

public class GrupoAlumnoServiceImpl implements IGrupoAlumnoService {

	@Autowired
	IGrupoAlumnoJpaRepository grupoAlumnoRepository;
	
	@Override
	public ResponseGC<GrupoAlumno> ConsultarTodos() {
		
		ResponseGC<GrupoAlumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		
		List<GrupoAlumno> listGA= grupoAlumnoRepository.findAll();
		
		response.setCount(listGA.size());
		response.setList(listGA);
		response.setMessage("Consulta correcta:)");
		response.setStatus("Oki doki");
		
		return response;
	}
}
