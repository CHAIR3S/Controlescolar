package com.utng.controlescolar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Login;
import com.utng.controlescolar.repository.ILoginJpaRepository;
import com.utng.controlescolar.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ILoginJpaRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException { //Metodo de la interfaz
		// TODO Auto-generated method stub
		
		Login login = loginRepository
			.findOneByCorreo(correo)
			.orElseThrow(() -> new UsernameNotFoundException( "El usuario con correo " + correo + " no existe" ) );
		
		return new UserDetailsImpl(login);
	}
	
 
}
