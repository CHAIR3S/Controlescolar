package com.utng.controlescolar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.AlumnoDTO;
import com.utng.controlescolar.dto.AlumnoFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Estatus;
import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.repository.IAlumnoJpaRepository;
import com.utng.controlescolar.repository.IConsultaAlumnoRepository;
import com.utng.controlescolar.repository.IEstatusJpaRepository;
import com.utng.controlescolar.repository.IGrupoJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	IAlumnoJpaRepository alumnoRepository;
	
	@Autowired
	IConsultaAlumnoRepository consultaAlumnoRepository;

	@Autowired
	IGrupoJpaRepository grupoRepository;
	
	@Autowired
	IEstatusJpaRepository estatusRepository;

	@Override
	public ResponseGC<Alumno> ConsultarTodos() {

		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		List<Alumno> listaAl = alumnoRepository.findAll();// Igualamos una lista a findAll del repository que nos trae a
															// todos los alumnos

		response.setCount(listaAl.size());// Le damos a response el tamaño o total de alumnos que hay en la DB
		response.setStatus("Oki");
		response.setMessage("Consultar todos los alumnos realizado correctamente");
		response.setList(listaAl);// Le damos a la lista genérica de response todos los alumnos para regresar los
									// resultados
		response.setData(null);

		return response;
	}

	@Override
	public ResponseGC<Alumno> GuardarAlumno(AlumnoDTO alumnoDto) {

		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		Optional<Estatus> estatusOptional = estatusRepository.findById(alumnoDto.getEstatus());
		Optional<Grupo> grupoOptional = grupoRepository.findById(alumnoDto.getGrupo());// Optional variable local para
		// comparar y ver si existe ese grupo en la DB

		if (!grupoOptional.isEmpty())// Si el idCiclo fue encontrado
		{
			Alumno alumno = new Alumno();// Alumno que se va a guardar

			alumno.setExpediente(alumnoDto.getExpediente());
			alumno.setNombre(alumnoDto.getNombre());
			alumno.setApePaterno(alumnoDto.getApePaterno());
			alumno.setApeMaterno(alumnoDto.getApeMaterno());
			alumno.setCurp(alumnoDto.getCurp());
			alumno.setGenero(alumnoDto.getGenero());
			alumno.setCorreo(alumnoDto.getCorreo());
			alumno.setEstatus(estatusOptional.get());
			alumno.setGrupo(grupoOptional.get());

			alumnoRepository.save(alumno);// Guardar en la base de datos al nuevo alumno

			response.setStatus("Oki doki");
			response.setMessage("Se guardó al alumno correctamente");
			response.setData(alumno);
		}
		else 
		{
			response.setStatus("Nel");
			response.setMessage("El grupo que escribiste no existe");
			response.setData(null);
		}
		return response;
	}

	@Override
	public ResponseGC<Alumno> BorrarAlumnoId(Integer idAlumno) {

		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		
		alumnoRepository.deleteById(idAlumno);// elimina alumno por id por método de la clase heredada JpaRepository

		response.setData(null);
		response.setMessage("Alumno eliminado correctamente:)");
		response.setStatus("Oki doki");

		return response;
	}
	
	
	@Override
	public ResponseGC<Alumno> BuscarAlumnoId(Integer idAlumno) {

		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		Optional<Alumno> alumno = alumnoRepository.findById(idAlumno);// elimina alumno por id por método de la clase heredada JpaRepository

		response.setData(alumno.get());
		response.setList(null);
		response.setMessage("Alumno encontrado correctamente");
		response.setStatus("Oki doki");

		return response;
	}


	@Override
	public ResponseGC<Alumno> ActualizarAlumno(AlumnoDTO alumnoDtoUpdate, AlumnoFiltroDTO filtro){

		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		
		response = consultaAlumnoRepository.actualizarAlumno(alumnoDtoUpdate, filtro);

		return response;
	}

	@Override
	public ResponseGC<Alumno> BuscarAlumno(AlumnoFiltroDTO filtro) {

		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		
		response = consultaAlumnoRepository.consultarAlumnoFiltro(filtro);

		return response;
	}

}
