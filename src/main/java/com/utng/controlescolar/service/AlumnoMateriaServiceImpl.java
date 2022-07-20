package com.utng.controlescolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.utng.controlescolar.model.AlumnoMateria;
import com.utng.controlescolar.repository.IAlumnoMateriaJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

public class AlumnoMateriaServiceImpl implements IAlumnoMateriaService {

	@Autowired
	IAlumnoMateriaJpaRepository alumnoMateriaRepository;
	
	@Override
	public ResponseGC<AlumnoMateria> ConsultarTodos() {
		
		ResponseGC<AlumnoMateria> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		
		List<AlumnoMateria> listAM = alumnoMateriaRepository.findAll();
		
		response.setCount(listAM.size());
		response.setList(listAM);
		response.setData(null);
		response.setMessage("Consulta realizada con éxito");
		response.setStatus("Oki doki");
		
		return response;
	}

}
