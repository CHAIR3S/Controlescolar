package com.utng.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utng.controlescolar.model.Login;

@Repository
public interface ILoginJpaRepository extends JpaRepository <Login, Integer>{
	
	List<Login> findByCorreoAndContraseña(String correo, String contraseña);

}
