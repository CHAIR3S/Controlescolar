package com.utng.controlescolar.repository;

import org.springframework.stereotype.Repository;

import com.utng.controlescolar.dto.MateriaDTO;
import com.utng.controlescolar.dto.MateriaFiltroDTO;
import com.utng.controlescolar.model.Materia;

@Repository
public interface IConsultaMateriaRepository {
	
	ResponseGC<Materia> ActualizarMateria(MateriaFiltroDTO filtro, MateriaDTO materiaUpdate);

}
