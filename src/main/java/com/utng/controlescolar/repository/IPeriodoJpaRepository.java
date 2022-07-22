package com.utng.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar.model.Periodo;

public interface IPeriodoJpaRepository extends JpaRepository <Periodo, Integer> {
	
}
