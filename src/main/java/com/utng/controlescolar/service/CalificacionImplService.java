package com.utng.controlescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.CalificacionDTO;
import com.utng.controlescolar.dto.CalificacionFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Calificacion;
import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.repository.IAlumnoJpaRepository;
import com.utng.controlescolar.repository.ICalificacionJpaRepository;
import com.utng.controlescolar.repository.IConsultaCalificacionRepository;
import com.utng.controlescolar.repository.IMateriaJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public class CalificacionImplService implements ICalificacionService {

	@Autowired
	ICalificacionJpaRepository caliRepository;
	
	@Autowired
	IConsultaCalificacionRepository consultaCalificacioRepository;
	
	@Autowired
	IAlumnoJpaRepository alumnoRepository;
	
	@Autowired
	IMateriaJpaRepository materiaRepository;
	
	@Override
	public ResponseGC<Calificacion> ConsultarTodos() {
		
		ResponseGC<Calificacion> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		List<Calificacion> listaCa = caliRepository.findAll();// Igualamos una lista a findAll del repository que nos trae a
															// todos los alumnos

		response.setCount(listaCa.size());// Le damos a response el tamaño o total de alumnos que hay en la DB
		response.setStatus("Oki");
		response.setMessage("Consultar todas las calificaciones realizado correctamente");
		response.setList(listaCa);// Le damos a la lista genérica de response todos los alumnos para regresar los
									// resultados
		response.setData(null);

		return response;
	}

	@Override
	public ResponseGC<Calificacion> GuardarCalificacion(CalificacionDTO calificacionDto) {

		ResponseGC<Calificacion> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		Optional<Alumno> alumnoOptional = alumnoRepository.findById(calificacionDto.getAlumno());
		Optional<Materia> materiaOptional = materiaRepository.findById(calificacionDto.getMateria());// Optional variable local para
		// comparar y ver si existe ese grupo en la DB

		if (!alumnoOptional.isEmpty() && !materiaOptional.isEmpty())// Si el id fue encontrado
		{
			Calificacion calif = new Calificacion();// Alumno que se va a guardar

			calif.setCal1(calificacionDto.getCal1());
			calif.setCal2(calificacionDto.getCal2());
			calif.setCal3(calificacionDto.getCal3());
			calif.setAlumno(alumnoOptional.get());
			calif.setMateria(materiaOptional.get());

			caliRepository.save(calif);// Guardar en la base de datos al nuevo alumno

			response.setStatus("Oki doki");
			response.setMessage("Se guardó al alumno correctamente");
			response.setData(calif);
		}
		else 
		{
			response.setStatus("Nel");
			response.setMessage("El Alumno o Materia que escribiste no existe");
			response.setData(null);
		}
		return response;
	}

	@Override
	public ResponseGC<Calificacion> BorrarCalificacionId(Integer idCalificacion) {

		ResponseGC<Calificacion> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		
		caliRepository.deleteById(idCalificacion);// elimina alumno por id por método de la clase heredada JpaRepository

		response.setData(null);
		response.setMessage("Calificacion eliminada correctamente:)");
		response.setStatus("Oki doki");

		return response;
	}

	@Override
	public ResponseGC<Calificacion> BuscarCalificacionMateriaAlumno (Integer alumno, Integer materia) {

		ResponseGC<Calificacion> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		List<Calificacion> calificacionList = caliRepository.findByAlumnoAndMateria(alumno, materia);
		
		if(!calificacionList.isEmpty())
		{
		response.setCount(calificacionList.size());
		response.setList(calificacionList);
		response.setMessage("Calificacion encontrada correctamente");
		response.setStatus("Okiiii");
		}
		else
		{
			response.setData(null);
			response.setList(null);
			response.setMessage("Calificacion no encontrada");
			response.setStatus("Oki doki");
		}
		
		return response;
	}

	@Override
	public ResponseGC<Calificacion> ActualizarCalificacion(CalificacionDTO calificacionUpdate, CalificacionFiltroDTO filtro) {

		ResponseGC<Calificacion> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		
		response = consultaCalificacioRepository.actualizarCalificacion(calificacionUpdate, filtro);

		return response;
	}

	@Override
	public ResponseGC<Calificacion> BuscarCalificacionId(Integer idCalificacion) {

		ResponseGC<Calificacion> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		Optional<Calificacion> calificacionOptional = caliRepository.findById(idCalificacion);// elimina alumno por id por método de la clase heredada JpaRepository

		if(!calificacionOptional.isEmpty())
		{
			response.setData(calificacionOptional.get());
			response.setList(null);
			response.setMessage("Calificacion encontrada correctamente");
			response.setStatus("Oki doki");
		}
		else
		{
			response.setData(null);
			response.setList(null);
			response.setMessage("Calificacion no encontrada");
			response.setStatus("Oki doki");
		}

		return response;
	}

}
