package com.utng.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar.model.Promedio;

public interface IPromedioJpaRepository extends JpaRepository <Promedio, Integer>{

}
