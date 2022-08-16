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

import com.utng.controlescolar.dto.CicloDTO;
import com.utng.controlescolar.dto.CicloFiltroDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.ResponseGC;
import com.utng.controlescolar.service.ICicloService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ciclo")
public class CicloController {
	
	
	@Autowired
	private ICicloService cicloService;
	
	
	@GetMapping(path = "/consultarTodos",
			produces = MediaType.APPLICATION_JSON_VALUE)//lo que va a mandar al usuario
	public ResponseEntity<ResponseGC<Ciclo>> consultarTodos(){
		
		ResponseGC<Ciclo> response = cicloService.ConsultarTodos();
		
		return new ResponseEntity<ResponseGC<Ciclo>> (response, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/guardarCiclo",
			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
			consumes = MediaType.APPLICATION_JSON_VALUE) //lo que va a recibir
	public ResponseEntity<ResponseGC <Ciclo>> guardarCiclo (@RequestBody CicloDTO ciclo){ //Requestbody es por que va a recibir
		
		//guardamos lo que mandó el método
		ResponseGC<Ciclo> response = cicloService.GuardarCiclo(ciclo);
		
		return new ResponseEntity<ResponseGC<Ciclo>> (response, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/borrarCiclo/{idCiclo}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Ciclo>> borrarCicloId(@PathVariable("idCiclo") Integer idCiclo){
		
		ResponseGC<Ciclo> response = cicloService.BorrarCicloPorId(idCiclo);
		
		return new ResponseEntity<ResponseGC<Ciclo>> (response, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/buscarCicloFiltro/",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Ciclo>> buscarCicloFiltro(CicloFiltroDTO filtro) {
		
		ResponseGC<Ciclo> response = cicloService.BuscarPorCicloClave(filtro);
		
		return new ResponseEntity<ResponseGC<Ciclo>> (response, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/buscarCicloPorId/{cicloId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Ciclo>> buscarCicloPorId(@PathVariable ("cicloId") Integer cicloId) {
		
		ResponseGC<Ciclo> response = cicloService.BuscarCicloPorId(cicloId);
		
		return new ResponseEntity<ResponseGC<Ciclo>> (response, HttpStatus.OK);
	}
	
	
	

}
