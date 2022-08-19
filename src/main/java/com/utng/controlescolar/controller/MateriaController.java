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

import com.utng.controlescolar.dto.MateriaAndFiltroDTO;
import com.utng.controlescolar.dto.MateriaDTO;
import com.utng.controlescolar.dto.MateriaFiltroDTO;
import com.utng.controlescolar.model.Materia;
import com.utng.controlescolar.repository.ResponseGC;
import com.utng.controlescolar.service.IMateriaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/materia")
public class MateriaController {
	
	
	@Autowired
	private IMateriaService materiaService;
	
	
	@GetMapping(path = "/consultarTodos",
			produces = MediaType.APPLICATION_JSON_VALUE)//lo que va a mandar al usuario
	public ResponseEntity<ResponseGC<Materia>> consultarTodos(){
		
		ResponseGC<Materia> response = materiaService.ConsultarTodos();
		
		return new ResponseEntity<ResponseGC<Materia>> (response, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/guardarMateria",
			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
			consumes = MediaType.APPLICATION_JSON_VALUE) //lo que va a recibir
	public ResponseEntity<ResponseGC <Materia>> guardarMateria (@RequestBody MateriaDTO materia){ //Requestbody es por que va a recibir
		
		//guardamos lo que mandó el método
		ResponseGC<Materia> response = materiaService.GuardarMateria(materia);
		
		return new ResponseEntity<ResponseGC<Materia>> (response, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/borrarMateriaId/{idMateria}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Materia>> borrarMateriaId(@PathVariable("idMateria") Integer idMateria){
		
		ResponseGC<Materia> response = materiaService.BorrarMateriaPorId(idMateria);
		
		return new ResponseEntity<ResponseGC<Materia>> (response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarMateria",
			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
			consumes = MediaType.APPLICATION_JSON_VALUE) //post por que va a recibir
	public ResponseEntity<ResponseGC<Materia>> actualizarMateria (@RequestBody MateriaAndFiltroDTO upToDate){ //Requestbody es por que va a recibir 
		//como consume y produce un json se pone el consumes y procuces "CIclo ciclo"
		
		MateriaFiltroDTO filtro = upToDate.getFiltro();
		MateriaDTO materiaDtoUpdate = upToDate.getMateriaUpdate();
		
		ResponseGC<Materia> response = materiaService.ActualizarMateria( filtro, materiaDtoUpdate);
		
		return new ResponseEntity<ResponseGC<Materia>> (response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/buscarMateriaFiltro/",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Materia>> buscarMateriaFiltro(MateriaFiltroDTO filtro) {
		
		String nombre = filtro.getNombre();
		String clave = filtro.getClave();
		
		ResponseGC<Materia> response = materiaService.BuscarMateriaPorNombreClave (nombre, clave);
		
		return new ResponseEntity<ResponseGC<Materia>> (response, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/buscarMateriaPorId/{materiaId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Materia>> buscarMateriaPorId(@PathVariable ("materiaId") Integer materiaId) {
		
		ResponseGC<Materia> response = materiaService.BuscarMateriaPorId(materiaId);
		
		return new ResponseEntity<ResponseGC<Materia>> (response, HttpStatus.OK);
	}
	
	

}
