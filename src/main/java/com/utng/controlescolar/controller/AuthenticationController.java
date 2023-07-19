package com.utng.controlescolar.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.controlescolar.model.Calificacion;
import com.utng.controlescolar.model.JwtRequest;
import com.utng.controlescolar.model.JwtResponse;
import com.utng.controlescolar.security.JwtUtils;
import com.utng.controlescolar.service.UserDetailsServiceImpl;
import com.utng.controlescolar.model.Login;
import com.utng.controlescolar.repository.ResponseGC;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		try {
			
			autenticar(jwtRequest.getCorreo(), jwtRequest.getContraseña());
			
		}catch ( Exception e ) {
			e.printStackTrace();
			throw new Exception("Usuario no encontrado");
		}
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getCorreo());
		String token = this.jwtUtils.generateToken(userDetails); //Generar token con los datos del usuario
		
		return ResponseEntity.ok(new JwtResponse(token));
		
		
		
	}
	
	
	private void autenticar (String correo, String contraseña) throws Exception{
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(correo, contraseña));
		}catch (DisabledException disabledException) {
			
			throw new Exception("Usuario Deshabilitado " + disabledException.getMessage());
			
		}catch(BadCredentialsException badCredentialsException){
			
			throw new Exception("Credenciales invalidas " + badCredentialsException.getMessage());
			
		}
	}
	
	
	@GetMapping("/usuarioActual")
	public ResponseEntity<ResponseGC<Login>> usuarioActual (Principal principal){
		
		ResponseGC<Login> response = new ResponseGC<Login>();
		
		Login login = (Login)this.userDetailsService.loadUserByUsername(principal.getName());
		
		response.setData(login);
		response.setList(null);
		response.setStatus("Ok");
		
		return new ResponseEntity<ResponseGC<Login>> (response, HttpStatus.OK);
		
	}

}
