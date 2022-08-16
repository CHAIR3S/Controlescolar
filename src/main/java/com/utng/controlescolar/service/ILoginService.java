package com.utng.controlescolar.service;

import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.LoginDTO;
import com.utng.controlescolar.dto.LoginFiltroDTO;
import com.utng.controlescolar.model.Login;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public interface ILoginService {
	
	ResponseGC<Login> ConsultarTodos();
	
	ResponseGC<Login> GuardarLogin(LoginDTO loginDto);
	
	ResponseGC<Login> BorrarLoginId(Integer idLogin);
	
	ResponseGC<Login> BuscarLoginId(Integer idLogin);
	
	ResponseGC<Login> BuscarLogin(LoginFiltroDTO filtro);

}
