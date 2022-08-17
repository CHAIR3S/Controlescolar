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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.dto.GrupoDTO;
import com.utng.controlescolar.dto.GrupoFiltroDTO;
import com.utng.controlescolar.model.Grupo;
import com.utng.controlescolar.repository.ResponseGC;
import com.utng.controlescolar.service.IGrupoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/grupo")
public class GrupoController {
	
	@Autowired
	private IGrupoService grupoService;
	
	
	@GetMapping(path = "/consultarTodos",
			produces = MediaType.APPLICATION_JSON_VALUE)//lo que va a mandar al usuario
	public ResponseEntity<ResponseGC<Grupo>> consultarTodos(){
		
		ResponseGC<Grupo> response = grupoService.ConsultarTodos();
		
		return new ResponseEntity<ResponseGC<Grupo>> (response, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/guardarGrupo",
			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
			consumes = MediaType.APPLICATION_JSON_VALUE) //lo que va a recibir
	public ResponseEntity<ResponseGC <Grupo>> guardarGrupo (@RequestBody GrupoDTO grupo){ //Requestbody es por que va a recibir
		
		//guardamos lo que mandó el método
		ResponseGC<Grupo> response = grupoService.GuardarGrupo(grupo);
		
		return new ResponseEntity<ResponseGC<Grupo>> (response, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/borrarGrupo/{idGrupo}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Grupo>> borrarMateriaId(@PathVariable("idGrupo") Integer idGrupo){
		
		ResponseGC<Grupo> response = grupoService.BorrarGrupoPorId(idGrupo);
		
		return new ResponseEntity<ResponseGC<Grupo>> (response, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/buscarGrupoFiltro/",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Grupo>> buscarGrupoFiltro(GrupoFiltroDTO filtro) {
		
		String nombre = filtro.getGrupo();
		Integer clave = filtro.getId();
		
		ResponseGC<Grupo> response = grupoService.BuscarPorNombreClave (nombre, clave);
		
		return new ResponseEntity<ResponseGC<Grupo>> (response, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/buscarGrupoPorId/{grupoId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseGC<Grupo>> buscarMateriaPorId(@PathVariable ("grupoId") Integer grupoId) {
		
		ResponseGC<Grupo> response = grupoService.BuscarGrupoPorId(grupoId);
		
		return new ResponseEntity<ResponseGC<Grupo>> (response, HttpStatus.OK);
	}
	
}
