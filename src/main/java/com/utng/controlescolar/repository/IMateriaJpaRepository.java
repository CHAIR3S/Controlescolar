package com.utng.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.dto.MateriaDTO;
import com.utng.controlescolar.model.Materia;

@Repository
public interface IMateriaJpaRepository extends JpaRepository<Materia, Integer>{
	
	List<Materia> findByNombreAndClave(String nombre, String clave);
	
//	ResponseGC<Materia> ActualizarMateria (Materia materia, MateriaDTO materiaDto);

}
