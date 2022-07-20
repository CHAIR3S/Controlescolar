package com.utng.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.model.AlumnoMateria;

@Repository
public interface IAlumnoMateriaJpaRepository extends JpaRepository<AlumnoMateria, Integer> {

}
