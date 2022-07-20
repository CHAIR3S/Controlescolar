package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.MateriaDTO;
import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface IMateriaService {
	
	ResponseGC<Materia> ConsultarTodos();
	
	ResponseGC<Materia> GuardarMateria(MateriaDTO materiaDto);
	
	ResponseGC<Materia> BuscarMateriaPorId(Integer id);
	
	ResponseGC<Materia> BorrarMateriaPorId(Integer id);
	
//	ResponseGC<Materia> ActualizarMateria(Materia materia, MateriaDTO materiaDto);
	
	ResponseGC<Materia> BuscarMateriaPorNombreClave (String nombre, String clave);

}
