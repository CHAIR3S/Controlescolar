package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.repository.ResponseGC;
import com.utng.controlescolar.service.IProfesorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/profesor")
public class ProfesorController {
	
	@Autowired
	private IProfesorService profesorService;
	
	
	@GetMapping(path = "/consultarTodos",
			produces = MediaType.APPLICATION_JSON_VALUE)//lo que va a mandar al usuario
	public ResponseEntity<ResponseGC<Profesor>> consultarTodos(){
		
		ResponseGC<Profesor> response = profesorService.ConsultarTodos();
		
		return new ResponseEntity<ResponseGC<Profesor>> (response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/buscarProfesorFiltro/",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Profesor>> buscarProfesorClave(String clave) {

		ResponseGC<Profesor> response = profesorService.BuscarProfesorClave (clave);
		
		return new ResponseEntity<ResponseGC<Profesor>> (response, HttpStatus.OK);
	}
	
}
