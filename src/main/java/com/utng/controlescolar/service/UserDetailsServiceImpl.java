package com.utng.controlescolar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.model.Login;
import com.utng.controlescolar.repository.ILoginJpaRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private ILoginJpaRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login> login = this.loginRepository.findOneByCorreo(username);
		
		if(login.isEmpty()) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return login.get();
	}

}
