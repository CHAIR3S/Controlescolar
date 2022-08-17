package com.utng.controlescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.ProMatGru;
import com.utng.controlescolar.repository.ResponseGC;
import com.utng.controlescolar.service.IProMatGruService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proMatGru")
public class ProMatGruService {
	
	@Autowired
	private IProMatGruService proMatGruService;
	

	@GetMapping(path = "/consultarTodos",
			produces = MediaType.APPLICATION_JSON_VALUE)//lo que va a mandar al usuario
	public ResponseEntity<ResponseGC<ProMatGru>> consultarTodos(){
		
		ResponseGC<ProMatGru> response = proMatGruService.consultarTodos();
		
		return new ResponseEntity<ResponseGC<ProMatGru>> (response, HttpStatus.OK);
	}

}
