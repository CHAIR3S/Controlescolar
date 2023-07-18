//package com.utng.controlescolar.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.utng.controlescolar.dto.LoginDTO;
//import com.utng.controlescolar.dto.LoginFiltroDTO;
//import com.utng.controlescolar.model.Login;
//import com.utng.controlescolar.repository.ResponseGC;
//import com.utng.controlescolar.service.ILoginService;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/Login")
//public class LoginService {
//	
//	@Autowired
//	private ILoginService loginService;
//	
//	
//	@GetMapping(path = "/consultarTodos",
//			produces = MediaType.APPLICATION_JSON_VALUE)//lo que va a mandar al usuario
//	public ResponseEntity<ResponseGC<Login>> consultarTodos(){
//		
//		ResponseGC<Login> response = loginService.ConsultarTodos();
//		
//		return new ResponseEntity<ResponseGC<Login>> (response, HttpStatus.OK);
//	}
//	
//	
//	@PostMapping(path = "/guardarLogin",
//			produces = MediaType.APPLICATION_JSON_VALUE, //lo que va a mandar al usuario
//			consumes = MediaType.APPLICATION_JSON_VALUE) //lo que va a recibir
//	public ResponseEntity<ResponseGC <Login>> guardarLogin (@RequestBody LoginDTO login){ //Requestbody es por que va a recibir
//		
//		//guardamos lo que mandó el método
//		ResponseGC<Login> response = loginService.GuardarLogin(login);
//		
//		return new ResponseEntity<ResponseGC<Login>> (response, HttpStatus.OK);
//	}
//	
//	
//	@DeleteMapping(path = "/borrarLogin/{idLogin}",
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ResponseGC<Login>> borrarLoginId(@PathVariable("idLogin") Integer idLogin){
//		
//		ResponseGC<Login> response = loginService.BorrarLoginId(idLogin);
//		
//		return new ResponseEntity<ResponseGC<Login>> (response, HttpStatus.OK);
//	}
//	
//	
//	@GetMapping(path = "/buscarLoginFiltro/",
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ResponseGC<Login>> buscarLoginFiltro(LoginFiltroDTO filtro) {
//		
//		ResponseGC<Login> response = loginService.BuscarLogin(filtro);
//		
//		return new ResponseEntity<ResponseGC<Login>> (response, HttpStatus.OK);
//	}
//	
//	
//	@GetMapping(path = "/buscarLoginPorId/{loginId}",
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ResponseGC<Login>> buscarLoginPorId(@PathVariable ("loginId") Integer loginId) {
//		
//		ResponseGC<Login> response = loginService.BuscarLoginId(loginId);
//		
//		return new ResponseEntity<ResponseGC<Login>> (response, HttpStatus.OK);
//	}
//	
//}
