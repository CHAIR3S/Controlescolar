//package com.utng.controlescolar.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.utng.controlescolar.model.ProfesorMateria;
//import com.utng.controlescolar.repository.IGrupoAlumnoJpaRepository;
//import com.utng.controlescolar.repository.ResponseGC;
//
//public class GrupoAlumnoServiceImpl implements IGrupoAlumnoService {
//
//	@Autowired
//	IGrupoAlumnoJpaRepository grupoAlumnoRepository;
//	
//	@Override
//	public ResponseGC<ProfesorMateria> ConsultarTodos() {
//		
//		ResponseGC<ProfesorMateria> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
//		
//		List<ProfesorMateria> listGA= grupoAlumnoRepository.findAll();
//		
//		response.setCount(listGA.size());
//		response.setList(listGA);
//		response.setMessage("Consulta correcta:)");
//		response.setStatus("Oki doki");
//		
//		return response;
//	}
//}
