package com.utng.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar.model.Profesor;

public interface IProfesorJpaRepository extends JpaRepository <Profesor, Integer>{
	
	List<Profesor> findByClave(String clave);

}
