package com.utng.controlescolar.service;

import com.utng.controlescolar.repository.ICicloJpaRepository;
import com.utng.controlescolar.repository.IMateriaJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.utng.controlescolar.dto.MateriaDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Materia;

public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	IMateriaJpaRepository materiaRepository;
	
	@Autowired
	ICicloJpaRepository cicloRepository;
	
	@Override
	public ResponseGC<Materia> ConsultarTodos() {
		
		ResponseGC<Materia> response = new ResponseGC<>();
		
		List<Materia> lMateria = materiaRepository.findAll();
		
		response.setList(lMateria);
		response.setCount(lMateria.size());
		response.setMessage("Consulta realizada correctamente");
		response.setStatus("Oki doki");
		
		return response;
	}

	@Override
	public ResponseGC<Materia> GuardarMateria(MateriaDTO materiaDto) {
		
		ResponseGC<Materia> response = new ResponseGC<>();

		Materia materia = new Materia();
		
		Optional<Ciclo> optionalCiclo = cicloRepository.findById(materiaDto.getCiclo());
		
		if(!optionalCiclo.isEmpty())
		{
			materia.setClave(materiaDto.getClave());
			materia.setCiclo(optionalCiclo.get());
			materia.setEstatus(materiaDto.getEstatus());
			materia.setNombre(materiaDto.getNombre());
			
			materiaRepository.save(materia);
			
			response.setData(materia);
			response.setMessage("Materia guardada correctamente");
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
	public ResponseGC<Materia> BuscarMateriaPorId(Integer id) {
		
		ResponseGC<Materia> response = new ResponseGC<>();
		
		Optional<Materia> optionalMateria = materiaRepository.findById(id);
		
		if(!optionalMateria.isEmpty())
		{
			response.setData(optionalMateria.get());
			response.setMessage("Grupo encontrado correctamente");
			response.setStatus("Okiiii");
		}
		else
		{
			response.setData(null);
			response.setMessage("Materia no encontrada");
			response.setStatus("Oki pero no encontrada");
		}
		
		return response;
	}

	@Override
	public ResponseGC<Materia> BorrarMateriaPorId(Integer id) {
		
		ResponseGC<Materia> response = new ResponseGC<>();
		
		materiaRepository.deleteById(id);
		
		response.setData(null);
		response.setMessage("Materia eliminada correctamente:)");
		response.setStatus("Oki jeje");
		
		return response;
	}

//	@Override
//	public ResponseGC<Materia> ActualizarMateria(Materia materia, MateriaDTO materiaDto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ResponseGC<Materia> BuscarMateriaPorNombreClave (String nombre, String clave) {
		
		ResponseGC<Materia> response = new ResponseGC<>();
		
		List <Materia> lMateria = materiaRepository.findByNombreAndClave(nombre, clave);
		
		if(!lMateria.isEmpty())
		{
			response.setCount(lMateria.size());
			response.setMessage("Materia encontrada correctamente");
			response.setStatus("Oki");
			response.setList(lMateria);
		}
		else
		{
			response.setList(null);
			response.setMessage("Materia no encontrada");
			response.setStatus("Oki pero no fue encontrada");
			response.setCount(lMateria.size());
		}
		
		return response;
	}
	

}
