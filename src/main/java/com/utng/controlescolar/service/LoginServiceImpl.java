package com.utng.controlescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.LoginDTO;
import com.utng.controlescolar.dto.LoginFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Login;
import com.utng.controlescolar.model.Profesor;
import com.utng.controlescolar.model.Rol;
import com.utng.controlescolar.repository.IAlumnoJpaRepository;
import com.utng.controlescolar.repository.ILoginJpaRepository;
import com.utng.controlescolar.repository.IProfesorJpaRepository;
import com.utng.controlescolar.repository.IRolJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginJpaRepository loginRepository;
	
	@Autowired
	IAlumnoJpaRepository alumnoRepository;
	
	@Autowired
	IRolJpaRepository rolRepository;
	
	@Autowired
	IProfesorJpaRepository profesorRepository;
	
	@Override
	public ResponseGC<Login> ConsultarTodos() {
		
		ResponseGC<Login> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		List<Login> listaLogin = loginRepository.findAll();// Igualamos una lista a findAll del repository que nos trae a
															// todos los alumnos

		response.setCount(listaLogin.size());// Le damos a response el tamaño o total de alumnos que hay en la DB
		response.setStatus("Oki");
		response.setMessage("Consultar todos los login realizado correctamente");
		response.setList(listaLogin);// Le damos a la lista genérica de response todos los alumnos para regresar los
									// resultados
		response.setData(null);

		return response;
	}

	@Override
	public ResponseGC<Login> GuardarLogin(LoginDTO loginDto) {

		ResponseGC<Login> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		Optional<Alumno> alumnoOptional = alumnoRepository.findById(loginDto.getAlumno());
		Optional<Rol> rolOptional = rolRepository.findById(loginDto.getRol());
		Optional<Profesor> profesorOptional = profesorRepository.findById(loginDto.getProfesor());
		
		if (!rolOptional.isEmpty())// Si el id fue encontrado
		{
			Login login = new Login();// Alumno que se va a guardar

			login.setCorreo(loginDto.getCorreo());
			login.setContraseña(loginDto.getContraseña());
			login.setRol(rolOptional.get());
			login.setProfesor(profesorOptional.get());
			login.setAlumno(alumnoOptional.get());

			loginRepository.save(login);// Guardar en la base de datos al nuevo alumno

			response.setStatus("Oki doki");
			response.setMessage("Se guardó al login correctamente");
			response.setData(login);
		}
		else 
		{
			response.setStatus("Nel");
			response.setMessage("El Rol que escribiste no existe");
			response.setData(null);
		}
		return response;
	}

	@Override
	public ResponseGC<Login> BorrarLoginId(Integer idLogin) {

		ResponseGC<Login> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		
		loginRepository.deleteById(idLogin);// elimina alumno por id por método de la clase heredada JpaRepository

		response.setData(null);
		response.setMessage("Calificacion eliminada correctamente:)");
		response.setStatus("Oki doki");

		return response;
	}

	@Override
	public ResponseGC<Login> BuscarLoginId(Integer idLogin) {

		ResponseGC<Login> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		Optional<Login> loginOptional = loginRepository.findById(idLogin);// elimina alumno por id por método de la clase heredada JpaRepository

		if(!loginOptional.isEmpty())
		{
			response.setData(loginOptional.get());
			response.setList(null);
			response.setMessage("Login encontrado correctamente");
			response.setStatus("Oki doki");
		}
		else
		{
			response.setData(null);
			response.setList(null);
			response.setMessage("Login no encontrado");
			response.setStatus("Oki doki");
		}

		return response;
	}

	@Override
	public ResponseGC<Login> BuscarLogin(LoginFiltroDTO filtro) {

		ResponseGC<Login> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		String correo, contraseña;
		
		correo = filtro.getCorreo();
		contraseña = filtro.getContraseña();
		
		List<Login> loginList = loginRepository.findByCorreoAndContraseña(correo, contraseña);
		
		if(!loginList.isEmpty())
		{
		response.setCount(loginList.size());
		response.setList(loginList);
		response.setMessage("Login encontrado correctamente");
		response.setStatus("Okiiii");
		}
		else
		{
			response.setData(null);
			response.setList(null);
			response.setMessage("login no encontrado");
			response.setStatus("Oki doki");
		}
		
		return response;
	}
	
	

}
