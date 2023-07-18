package com.utng.controlescolar.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.model.Rol;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {

	
	private final static String ACCESS_TOKEN_SECRET = "cf79V2KeJ2eLyNjw8DyfjO9MzaBb1TcX";
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
	
	
	public static String createToken(String correo, Rol rol, Profesor profesor, Alumno alumno) {
		
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		
		
		Map<String, Object> extra = new HashMap<>();   //Datos que se enviaran junto con el token
		extra.put("rol", rol);
		extra.put("profesor", profesor);
		extra.put("alumno", alumno);
		
		return Jwts.builder()
				.setSubject(correo)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
		
	}
	
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {  //Metodo que recibe el token y spring verifica para dar acceso
		
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();
			
			String correo = claims.getSubject();
			
			return new UsernamePasswordAuthenticationToken(correo, null, Collections.emptyList());
			
		}catch(JwtException e) {
			return null;
		}
		
	}
}








