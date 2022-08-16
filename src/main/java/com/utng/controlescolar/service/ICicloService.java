package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.CicloDTO;
import com.utng.controlescolar.dto.CicloFiltroDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface ICicloService {
	
	ResponseGC<Ciclo> ConsultarTodos();
	
	ResponseGC<Ciclo> GuardarCiclo(CicloDTO cicloDto);
	 
	ResponseGC<Ciclo> BuscarCicloPorId(Integer id);
	
	ResponseGC<Ciclo> BorrarCicloPorId(Integer id);
	
	ResponseGC<Ciclo> BuscarPorCicloClave(CicloFiltroDTO cicloDto);

}
