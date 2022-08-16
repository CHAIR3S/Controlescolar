package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.GrupoDTO;
import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface IGrupoService {

	ResponseGC<Grupo> ConsultarTodos();
	
	ResponseGC<Grupo> GuardarGrupo(GrupoDTO grupoDto);
	
	ResponseGC<Grupo> BuscarGrupoPorId(Integer id);
	
	ResponseGC<Grupo> BorrarGrupoPorId(Integer id);
	
	ResponseGC<Grupo> BuscarPorNombreClave(String grupo, Integer id);
	
	
	
}
