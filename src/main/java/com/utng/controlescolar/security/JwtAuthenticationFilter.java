package com.utng.controlescolar.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.utng.controlescolar.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;


// Filtro que intercepta todas las peticiones hacia el servidor, valida la existencia del token y si es valido
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String requestTokenHeader = request.getHeader("Authorization"); //Obtener encabezado Authorization de la solicitud 
		String correo = null;
		String jwtToken = null;
		
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) { // Si empieza con Bearer y si existe
			jwtToken = requestTokenHeader.substring(7); //Se extrae el token sin el Bearer
			
			try {
				
				correo = this.jwtUtils.extractUsername(jwtToken); //Se extrae el username del token
				
			} catch (ExpiredJwtException expiredJwtException) {
				
				System.out.println("El token ha expirado");
				
			} catch (Exception exception) {
				
				exception.printStackTrace();
				
			}
		}
		else
		{
			System.out.println("Token invalido, no empieza con bearer string");
		}
		
		
		if(correo != null && SecurityContextHolder.getContext().getAuthentication() == null) { //
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(correo);
			
			if(this.jwtUtils.validateToken(jwtToken, userDetails)) { //Se encarga de que sean iguales el username y que el token no haya expirado
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); //Se pasan tambien los roles
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
		}
		else // Si el token no es valido
		{
			System.out.println("El token no es valido");
		}
			
		filterChain.doFilter(request, response);
		
		
	}

}
