package com.utng.controlescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.controlescolar.dto.CicloDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.repository.ICicloJpaRepository;
import com.utng.controlescolar.repository.ResponseGC;

@Service
public class CicloServiceImpl implements ICicloService {

	@Autowired
	ICicloJpaRepository cicloRepository;
	
	@Override
	public ResponseGC<Ciclo> ConsultarTodos() {
		
		ResponseGC<Ciclo> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		List<Ciclo> listC = cicloRepository.findAll();// Igualamos una lista a findAll del repository que nos trae a
															// todos los ciclos

		response.setCount(listC.size());// Le damos a response el tamaño o total de ciclos que hay en la DB
		response.setStatus("Oki");
		response.setMessage("Consultar todos los ciclos realizado correctamente");
		response.setList(listC);// Le damos a la lista genérica de response todos los alumnos para regresar los
									// resultados
		response.setData(null);

		return response;
	}

	@Override
	public ResponseGC<Ciclo> GuardarCiclo(Ciclo ciclo) {

		ResponseGC<Ciclo> response = new ResponseGC<>();
		
		Ciclo ciclo1 = cicloRepository.save(ciclo);
		
		response.setStatus("OKi doki");
		response.setMessage("Ciclo guardado correctamente");
		response.setData(ciclo1);
		
		return response;
	}

	@Override
	public ResponseGC<Ciclo> BuscarCicloPorId(Integer id) {
		
		ResponseGC<Ciclo> response = new ResponseGC<>();
		
		Optional<Ciclo> optionalCiclo = cicloRepository.findById(id);
		
		if(!optionalCiclo.isEmpty())
		{
			response.setData(optionalCiclo.get());
			response.setMessage("Se encontró el ciclo");
			response.setStatus("Oki");
		}
		else
		{
			response.setData(null);
			response.setMessage("El ciclo no fue encontrado:(");
			response.setStatus("Nel");
		}
		
		
		return response;
	}

	@Override
	public ResponseGC<Ciclo> BorrarCicloPorId(Integer id) {
		
		ResponseGC<Ciclo> response = new ResponseGC<>();
		
		cicloRepository.deleteById(id);
		
		response.setMessage("Ciclo borrado correctamente");
		response.setStatus("Oki");
		
		return response;
	}

//	@Override
//	public ResponseGC<Ciclo> ActualizarCiclo(Ciclo ciclo, Ciclo cicloUpdate) {
//		
//		ResponseGC<Ciclo> response = new ResponseGC<>();
//		
//		response = cicloRepository.ActualizarCiclo(ciclo, cicloUpdate);
//		
//		return response;
//	}

	@Override
	public ResponseGC<Ciclo> BuscarPorCicloClave(CicloDTO cicloDto) {
		
		ResponseGC<Ciclo> response = new ResponseGC<>();
		
		String ciclo, clave;
		ciclo = cicloDto.getCiclo();
		clave = cicloDto.getClave();
		
		List<Ciclo> lCiclo = cicloRepository.findByCicloAndClave(ciclo, clave);
		
		if(!lCiclo.isEmpty() && lCiclo.size() == 1)
		{
			response.setCount(lCiclo.size());
			response.setList(lCiclo);
			response.setMessage("Supongo que se encontró al ciclo buscado");
			response.setStatus("Completed:)");
		}
		else
		{
			response.setCount(lCiclo.size());
			response.setList(null);
			response.setMessage("No se encontró ningún ciclo con esas características o está repetido el ciclo");
			response.setStatus("Ok pero no encontrado");
		}
		
		return response;
	}
	

}
