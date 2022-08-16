package com.utng.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utng.controlescolar.model.Grupo;

public interface IGrupoJpaRepository extends JpaRepository <Grupo, Integer>{

     List<Grupo> findByGrupoAndId(String grupo, Integer id);
     
}
