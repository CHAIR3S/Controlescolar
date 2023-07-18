package com.utng.controlescolar.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter { //filtro para proceso de autorizacion cuando cliente desee utilizar token
	//adjuntado a los endpoints de la api

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
									HttpServletResponse response, 
									FilterChain filterChain)
									throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String bearerToken = request.getHeader("Authorization"); //Se extrae el header authorization del request y va a contener el bearer y token
		
		if(bearerToken != null && bearerToken.startsWith("Bearer ")) { //Si si existe bearer y si esta en el formato correcto
			
			String token  = bearerToken.replace("Bearer ", ""); //Se le quita el prefijo Bearer
			
			UsernamePasswordAuthenticationToken usernamePAT =  TokenUtils.getAuthentication(token);
			
			SecurityContextHolder.getContext().setAuthentication(usernamePAT); //Establecer autenticacion
			
		}
		
		
		filterChain.doFilter(request, response);
		
		
		
	}

}
