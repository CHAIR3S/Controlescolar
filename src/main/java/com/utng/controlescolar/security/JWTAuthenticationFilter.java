package com.utng.controlescolar.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter { //Primer proceso de autrntificacion
	

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		
		AuthCredentials authCredentials = new AuthCredentials();
		
		
		//Si nos envian las credenciales en un formato JSON
		try {
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
		} catch(IOException e) { //Por si el usuario pasa mal las credenciales
			
		}
		
		UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
				authCredentials.getCorreo(),
				authCredentials.getContraseña(),
				Collections.emptyList()
				);
		
		
		
		return getAuthenticationManager().authenticate(usernamePAT);
	}
	
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
											HttpServletResponse response, 
											FilterChain chain,
											Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
		
		
		// Creacion de token a partir de UserDetailsImpl
		String token = TokenUtils.createToken(userDetails.getUsername(), userDetails.getRol(), userDetails.getProfesor(), userDetails.getAlumno());
		
		response.addHeader("Authorization", "Bearer " + token);
		response.getWriter().flush();
		
		
		super.successfulAuthentication(request, response, chain, authResult);
	}
	

}









