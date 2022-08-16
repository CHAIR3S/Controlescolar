package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.ProMatGru;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface IProMatGruService {
	
	ResponseGC<ProMatGru> consultarTodos();

}
