package com.utng.controlescolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.utng.controlescolar.model.ProMatGru;
import com.utng.controlescolar.repository.IProMatGruJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

public class ProMatGruImplService implements IProMatGruService {

	@Autowired
	IProMatGruJpaRepository promatgruRepository;
	
	@Override
	public ResponseGC<ProMatGru> consultarTodos() {
		
		ResponseGC<ProMatGru> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		
		List<ProMatGru> listPMG = promatgruRepository.findAll();
		
		response.setCount(listPMG.size());
		response.setList(listPMG);
		response.setData(null);
		response.setMessage("Consulta realizada con éxito");
		response.setStatus("Oki doki");
		
		return response;
	}

}
