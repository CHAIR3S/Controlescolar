package com.utng.controlescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.GrupoDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.repository.ICicloJpaRepository;
import com.utng.controlescolar.repository.IGrupoJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public class GrupoImplService implements IGrupoService {

	@Autowired
	IGrupoJpaRepository grupoRepository;
	
	@Autowired
	ICicloJpaRepository cicloRepository;
	
	@Override
	public ResponseGC<Grupo> ConsultarTodos() {
		
		ResponseGC<Grupo> response = new ResponseGC<>();
		
		List<Grupo> lGrupo = grupoRepository.findAll();
		
		response.setList(lGrupo);
		response.setCount(lGrupo.size());
		response.setMessage("Consulta realizada correctamente");
		response.setStatus("Oki doki");
		
		return response;
	}

	@Override
	public ResponseGC<Grupo> GuardarGrupo(GrupoDTO grupoDto) {
		
		ResponseGC<Grupo> response = new ResponseGC<>();

		Grupo grupo = new Grupo();
		
		Optional<Ciclo> optionalCiclo = cicloRepository.findById(grupoDto.getCiclo());
		
		if(!optionalCiclo.isEmpty())
		{
			grupo.setId(grupoDto.getId());
			grupo.setCiclo(optionalCiclo.get());
			grupo.setEstatus(grupoDto.getEstatus());
			grupo.setGrupo(grupoDto.getGrupo());
			
			grupoRepository.save(grupo);
			
			response.setData(grupo);
			response.setMessage("Grupo guardado correctamente");
			response.setList(null);
			response.setStatus("Oki doki");
		}
		else
		{
			response.setData(null);
			response.setMessage("El ciclo digitado es incorrecto o no existe");
			response.setStatus("Oki pero no guardado");
			response.setList(null);
		}
		
		return response;
	}

	@Override
	public ResponseGC<Grupo> BuscarGrupoPorId(Integer id) {
		
		ResponseGC<Grupo> response = new ResponseGC<>();
		
		Optional<Grupo> optionalGrupo = grupoRepository.findById(id);
		
		if(!optionalGrupo.isEmpty())
		{
			response.setData(optionalGrupo.get());
			response.setMessage("Grupo encontrado correctamente");
			response.setStatus("Okiiii");
		}
		else
		{
			response.setData(null);
			response.setMessage("Grupo no encontrado");
			response.setStatus("Oki pero no encontrado");
		}
		
		return response;
	}

	@Override
	public ResponseGC<Grupo> BorrarGrupoPorId(Integer id) {
		
		ResponseGC<Grupo> response = new ResponseGC<>();
		
		grupoRepository.deleteById(id);
		
		response.setData(null);
		response.setMessage("Grupo eliminado correctamente:)");
		response.setStatus("Oki jeje");
		
		return response;
	}

//	@Override
//	public ResponseGC<Grupo> ActualizarGrupo(GrupoDTO grupoUpdate, Grupo grupo) {
//		
//		ResponseGC<Grupo> response = new ResponseGC<>();
//		
//		response = grupoRepository.ActualizarGrupo(grupo, grupoUpdate);
//		
//		return response;
//	}

	@Override
	public ResponseGC<Grupo> BuscarPorNombreClave(String grupo, Integer id) {
		
		ResponseGC<Grupo> response = new ResponseGC<>();
		
		List<Grupo> lGrupo = grupoRepository.findByGrupoAndId(grupo, id);
		
		if(!lGrupo.isEmpty())
		{
			response.setList(lGrupo);
			response.setCount(lGrupo.size());
			response.setMessage("Grupo encontrado correctamente");
			response.setStatus("Oki");
		}
		else
		{
			response.setList(null);
			response.setMessage("Grupo no encontrado:(");
			response.setStatus("Good");
		}
		
		return response;
	}
}
