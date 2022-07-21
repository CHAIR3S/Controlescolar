package com.utng.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar.model.ProfesorMateria;

public interface IGrupoAlumnoJpaRepository extends JpaRepository <ProfesorMateria, Integer>{

}
