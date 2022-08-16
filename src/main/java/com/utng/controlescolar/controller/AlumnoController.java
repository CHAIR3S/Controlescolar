package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.utng.controlescolar.dto.AlumnoAndFiltroDTO;
import com.utng.controlescolar.dto.AlumnoDTO;
import com.utng.controlescolar.dto.AlumnoFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.repository.ResponseGC;

import com.utng.controlescolar.service.IAlumnoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService alumnoService;
	
	
	@GetMapping(path = "/consultarTodos",
			produces = MediaType.APPLICATION_JSON_VALUE)//lo que va a mandar al usuario
	public ResponseEntity<ResponseGC<Alumno>> consultarTodos(){
		
		ResponseGC<Alumno> response = alumnoService.ConsultarTodos();
		
		return new ResponseEntity<ResponseGC<Alumno>> (response, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/guardarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
			consumes = MediaType.APPLICATION_JSON_VALUE) //lo que va a recibir
	public ResponseEntity<ResponseGC <Alumno>> guardarAlumno (@RequestBody AlumnoDTO alumno){ //Requestbody es por que va a recibir
		
		//guardamos lo que mandó el método
		ResponseGC<Alumno> response = alumnoService.GuardarAlumno(alumno);
		
		return new ResponseEntity<ResponseGC<Alumno>> (response, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/borrarAlumno/{idAlumno}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Alumno>> borrarAlumnoId(@PathVariable("idAlumno") Integer idAlumno){
		
		ResponseGC<Alumno> response = alumnoService.BorrarAlumnoId(idAlumno);
		
		return new ResponseEntity<ResponseGC<Alumno>> (response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarAlumno",
			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a recibir
	public ResponseEntity<ResponseGC<Alumno>> actualizarAlumno (@RequestBody AlumnoAndFiltroDTO upToDate){ //Requestbody es por que va a recibir 
		//como consume y produce un json se pone el consumes y procuces "CIclo ciclo"
		
		AlumnoFiltroDTO filtro = upToDate.getFiltro();
		AlumnoDTO alumnoDtoUpdate = upToDate.getAlumnoUpdate();
		
		ResponseGC<Alumno> response = alumnoService.ActualizarAlumno(alumnoDtoUpdate, filtro);
		
		return new ResponseEntity<ResponseGC<Alumno>> (response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/buscarAlumnoFiltro/",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Alumno>> buscarAlumnoFiltro(AlumnoFiltroDTO filtro) {
		
		ResponseGC<Alumno> response = alumnoService.BuscarAlumno(filtro);
		
		return new ResponseEntity<ResponseGC<Alumno>> (response, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/buscarAlumnoPorId/{alumnoId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Alumno>> buscarAlumnoPorId(@PathVariable ("alumnoId") Integer alumnoId) {
		
		ResponseGC<Alumno> response = alumnoService.BuscarAlumnoId(alumnoId);
		
		return new ResponseEntity<ResponseGC<Alumno>> (response, HttpStatus.OK);
	}
	
	
	
	
	
	

}
