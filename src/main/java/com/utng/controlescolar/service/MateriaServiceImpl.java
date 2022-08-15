package com.utng.controlescolar.service;

import com.utng.controlescolar.repository.ICicloJpaRepository;
import com.utng.controlescolar.repository.IConsultaMateriaRepository;
import com.utng.controlescolar.repository.IEstatusJpaRepository;
import com.utng.controlescolar.repository.IMateriaJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.MateriaDTO;
import com.utng.controlescolar.dto.MateriaFiltroDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Estatus;
import com.utng.controlescolar.model.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	IMateriaJpaRepository materiaRepository;

	@Autowired
	ICicloJpaRepository cicloRepository;
	
	@Autowired
	IConsultaMateriaRepository consultaMateriaRepository;
	
	@Autowired
	IEstatusJpaRepository estatusRepository;

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
		Optional<Estatus> optionalEstatus = estatusRepository.findById(materiaDto.getEstatus());

		if (!optionalCiclo.isEmpty()) {
			materia.setClave(materiaDto.getClave());
			materia.setNombre(materiaDto.getNombre());
			materia.setEstatus(optionalEstatus.get());
			materia.setCiclo(optionalCiclo.get());

			materiaRepository.save(materia);

			response.setData(materia);
			response.setMessage("Materia guardada correctamente");
			response.setList(null);
			response.setStatus("Oki doki");
		} else {
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

		if (!optionalMateria.isEmpty()) {
			response.setData(optionalMateria.get());
			response.setMessage("Grupo encontrado correctamente");
			response.setStatus("Okiiii");
		} else {
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

	@Override
	public ResponseGC<Materia> ActualizarMateria(MateriaFiltroDTO filtro, MateriaDTO materiaDto) {
		
		ResponseGC<Materia> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		response = consultaMateriaRepository.ActualizarMateria(filtro, materiaDto);

		return response;
	}

	@Override
	public ResponseGC<Materia> BuscarMateriaPorNombreClave(String nombre, String clave) {

		ResponseGC<Materia> response = new ResponseGC<>();

		List<Materia> lMateria = materiaRepository.findByNombreAndClave(nombre, clave);

		if (!lMateria.isEmpty()) {
			response.setCount(lMateria.size());
			response.setMessage("Materia encontrada correctamente");
			response.setStatus("Oki");
			response.setList(lMateria);
		} else {
			response.setList(null);
			response.setMessage("Materia no encontrada");
			response.setStatus("Oki pero no fue encontrada");
			response.setCount(lMateria.size());
		}

		return response;
	}

}
