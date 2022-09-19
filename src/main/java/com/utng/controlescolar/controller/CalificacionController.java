package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.dto.CalificacionAndFiltroDTO;
import com.utng.controlescolar.dto.CalificacionDTO;
import com.utng.controlescolar.dto.CalificacionFiltroDTO;
import com.utng.controlescolar.model.Calificacion;
import com.utng.controlescolar.repository.ResponseGC;
import com.utng.controlescolar.service.ICalificacionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/calificacion")
public class CalificacionController {
	
	@Autowired
	private ICalificacionService calificacionService;
	
	@GetMapping(path = "/consultarTodos",
			produces = MediaType.APPLICATION_JSON_VALUE)//lo que va a mandar al usuario
	public ResponseEntity<ResponseGC<Calificacion>> consultarTodos(){
		
		ResponseGC<Calificacion> response = calificacionService.ConsultarTodos();
		
		return new ResponseEntity<ResponseGC<Calificacion>> (response, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/guardarCalificacion",
			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
			consumes = MediaType.APPLICATION_JSON_VALUE) //lo que va a recibir
	public ResponseEntity<ResponseGC <Calificacion>> guardarCalificacion (@RequestBody CalificacionDTO calificacion){ //Requestbody es por que va a recibir
		
		//guardamos lo que mandó el método
		ResponseGC<Calificacion> response = calificacionService.GuardarCalificacion(calificacion);
		
		return new ResponseEntity<ResponseGC<Calificacion>> (response, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/borrarCalificacion/{idCalificacion}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Calificacion>> borrarCalificacionId(@PathVariable("idCalificacion") Integer idCalificacion){
		
		ResponseGC<Calificacion> response = calificacionService.BorrarCalificacionId(idCalificacion);
		
		return new ResponseEntity<ResponseGC<Calificacion>> (response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarCalificacion",
			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a recibir
	public ResponseEntity<ResponseGC<Calificacion>> actualizarCalificacion (@RequestBody CalificacionAndFiltroDTO upToDate){ //Requestbody es por que va a recibir 
		//como consume y produce un json se pone el consumes y procuces "CIclo ciclo"
		
		ResponseGC<Calificacion> response = calificacionService.ActualizarCalificacion(upToDate);
		
		return new ResponseEntity<ResponseGC<Calificacion>> (response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/buscarCalificacionAlumno/{idAlumno}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Calificacion>> buscarCalificacionAlumno(@PathVariable("idAlumno")Integer idAlumno) {
		
		ResponseGC<Calificacion> response = calificacionService.BuscarCalificacionAlumno(idAlumno);
		
		return new ResponseEntity<ResponseGC<Calificacion>> (response, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/buscarCalificacionPorId/{calificacionId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Calificacion>> buscarCalificacionPorId(@PathVariable ("calificacionId") Integer calificacionId) {
		
		ResponseGC<Calificacion> response = calificacionService.BuscarCalificacionId(calificacionId);
		
		return new ResponseEntity<ResponseGC<Calificacion>> (response, HttpStatus.OK);
	}

}
