package com.utng.controlescolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.repository.IProfesorJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	IProfesorJpaRepository profesorRepository;
	
	@Override
	public ResponseGC<Profesor> ConsultarTodos() {
		
		ResponseGC<Profesor> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		List<Profesor> listaProfesor = profesorRepository.findAll();// Igualamos una lista a findAll del repository que nos trae a
															// todos los alumnos

		response.setCount(listaProfesor.size());// Le damos a response el tamaño o total de alumnos que hay en la DB
		response.setStatus("Oki");
		response.setMessage("Consultar todos los profesores realizado correctamente");
		response.setList(listaProfesor);// Le damos a la lista genérica de response todos los alumnos para regresar los
									// resultados
		response.setData(null);

		return response;
	}

	@Override
	public ResponseGC<Profesor> BuscarProfesorClave(String clave) {

		ResponseGC<Profesor> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		List<Profesor> profesorList = profesorRepository.findByClave(clave);
		
		if(!profesorList.isEmpty())
		{
		response.setCount(profesorList.size());
		response.setList(profesorList);
		response.setMessage("Calificacion encontrada correctamente");
		response.setStatus("Okiiii");
		}
		else
		{
			response.setData(null);
			response.setList(null);
			response.setMessage("Profesor no encontrado");
			response.setStatus("Oki doki");
		}
		
		return response;
	}

}
