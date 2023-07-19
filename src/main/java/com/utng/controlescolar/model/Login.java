package com.utng.controlescolar.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "MASTER_TBL_LOGIN") //llamamos la tabla de la base de datos
public class Login implements UserDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Que va incrementando automáticamente cada primary key 
	
	@Column(name = "PK_LOGIN")
	private Integer id;
	
	@Column(name = "TXT_CORREO")
	private String correo;
	
	@Column(name = "TXT_PASSWORD")
	private String contraseña;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_ROL")
	private Rol rol;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_PROFESOR")
	private Profesor profesor;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "FK_ALUMNO")
	private Alumno alumno;
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> autoridades = new HashSet<>();
		autoridades.add(new Authority(rol.getRol()));
		return autoridades;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return contraseña;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return correo;
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
	
}
