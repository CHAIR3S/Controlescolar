package com.utng.controlescolar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.dto.CicloFiltroDTO;
import com.utng.controlescolar.model.Ciclo;

@Repository
public interface ICicloJpaRepository extends JpaRepository<Ciclo, Integer>{
	
	List<Ciclo> findByCicloAndClave(String ciclo, String clave);

	ResponseGC<Ciclo> ActualizarCiclo(Ciclo ciclo, Ciclo cicloUpdate);
}
