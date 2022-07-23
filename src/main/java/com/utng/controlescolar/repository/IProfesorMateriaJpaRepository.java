package com.utng.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar.model.ProfesorMateria;

public interface IProfesorMateriaJpaRepository extends JpaRepository <ProfesorMateria, Integer> {

}
