package com.utng.controlescolar.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Login;
import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.model.Rol;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

	
	private final Login login;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return login.getContraseña();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login.getCorreo();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	public Rol getRol() {
		return login.getRol();
	}
	
	public Profesor getProfesor() {
		return login.getProfesor();
	}
	
	public Alumno getAlumno() {
		return login.getAlumno();
	}

}
