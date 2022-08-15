package com.utng.controlescolar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.utng.controlescolar.dto.AlumnoDTO;
import com.utng.controlescolar.dto.AlumnoFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Estatus;
import com.utng.controlescolar.model.Grupo;

import org.springframework.stereotype.Repository;

@Repository
public class ConsultaAlumnoImplRepository implements IConsultaAlumnoRepository {

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;

	@Autowired
	IGrupoJpaRepository grupoRepository;

	@Autowired
	IEstatusJpaRepository estatusRepository;
	
	@Autowired
	IAlumnoJpaRepository alumnoRepository;

	@Override
	public ResponseGC<Alumno> consultarAlumnoFiltro(AlumnoFiltroDTO filtro) {
		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC

		List<Predicate> predicates = new ArrayList<>();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Alumno> configConsulta = cb.createQuery(Alumno.class);
		Root<Alumno> raizAlumno = configConsulta.from(Alumno.class);

		// Creando los predicados que se van a usar en la consulta y comprobando si no
		// están vacíos
		if (filtro.getCorreo() != null) {
			predicates.add(
					cb.like(raizAlumno.get("correo"), filtro.getCorreo()));
		}
		if (filtro.getCurp() != null) {
			predicates.add(
					cb.like(raizAlumno.get("curp"), filtro.getCurp()));
		}
		if (filtro.getExpediente() != null) {
			predicates.add(
					cb.like(raizAlumno.get("expediente"), filtro.getExpediente()));
		}

		Predicate[] pr = predicates.toArray(new Predicate[predicates.size()]);

		configConsulta.select(raizAlumno).where(pr);
		
		List<Alumno> alumno = entityManager.createQuery(configConsulta).getResultList();

		if (!alumno.isEmpty()) {
			response.setStatus("En teoría todo okay");
			response.setCount(alumno.size());
			response.setList(alumno);
			response.setMessage("Consulta realizada con éxito");
		} 
		else 
		{
			response.setStatus("No encontrado");
			response.setCount(alumno.size());
			response.setList(null);
			response.setData(null);
			response.setMessage("El alumno no fue encontrado:(");
		}

		entityManager.close();

		return response;
	}

	@Override
	@Transactional
	public ResponseGC<Alumno> actualizarAlumno(AlumnoDTO alumnoDtoUpdate, AlumnoFiltroDTO filtro) {

		// Listas que usaremos
		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		List<Predicate> predicates = new ArrayList<>();
		String expediente = filtro.getExpediente();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Alumno> configConsulta = cb.createCriteriaUpdate(Alumno.class);
		Root<Alumno> raizAlumno = configConsulta.from(Alumno.class);

		Optional<Grupo> grupoOptional = grupoRepository.findById(alumnoDtoUpdate.getGrupo());
		Optional<Estatus> estatusOptional = estatusRepository.findById(alumnoDtoUpdate.getEstatus());
		List<Alumno> alumnoList = alumnoRepository.findByExpediente(expediente);
//		
//		response = consulta.consultarAlumnoFiltro(filtro);

		if (!grupoOptional.isEmpty()) {
//			if(alumnoDtoUpdate.getExpediente() != null) 
//			{
				configConsulta.set(raizAlumno.<String>get("expediente"), alumnoDtoUpdate.getExpediente());
//			}
//			if(alumnoDtoUpdate.getNombre() != null)
//			{
				configConsulta.set(raizAlumno.<String>get("nombre"), alumnoDtoUpdate.getNombre());
//			}
//			if (alumnoDtoUpdate.getApePaterno() != null)
//			{
				configConsulta.set(raizAlumno.<String>get("apePaterno"), alumnoDtoUpdate.getApePaterno());
//			}
//			if (alumnoDtoUpdate.getApeMaterno() != null)
//			{
				configConsulta.set(raizAlumno.<String>get("apeMaterno"), alumnoDtoUpdate.getApeMaterno());
//			}
//			if (alumnoDtoUpdate.getCurp() != null)
//			{
				configConsulta.set(raizAlumno.<String>get("curp"), alumnoDtoUpdate.getCurp());
//			}
//			if (alumnoDtoUpdate.getGenero() != null)
//			{
				configConsulta.set(raizAlumno.<String>get("genero"), alumnoDtoUpdate.getGenero());
//			}
//			if (alumnoDtoUpdate.getCorreo() != null)
//			{
				configConsulta.set(raizAlumno.<String>get("correo"), alumnoDtoUpdate.getCorreo());
//			}
//			if (estatusOptional.get() != null)
//			{
				configConsulta.set(raizAlumno.<Estatus>get("estatus"), estatusOptional.get());
//			}
//			if (grupoOptional.get() != null)
//			{
				configConsulta.set(raizAlumno.<Grupo>get("grupo"), grupoOptional.get());
//			}

			
			if (filtro.getExpediente() != null)
			{
				predicates.add(
						cb.like(raizAlumno.get("expediente"), filtro.getExpediente()));
			}
			if (filtro.getCurp() != null)
			{
				predicates.add(
						cb.like(raizAlumno.get("curp"), filtro.getCurp()));
			}
			if (filtro.getCorreo() != null)
			{
				predicates.add(
						cb.like(raizAlumno.get("correo"), filtro.getCorreo()));
			}

//	:)		.where(cb.equal(raizAlumno.get("expediente"), "%" +  alumno.getExpediente() + "%"))
//	:)		.where(cb.equal(raizAlumno.get("curp"), "%" +  alumno.getCurp() + "%"))
//	:)		.where(cb.equal(raizAlumno.get("correo"), "%" +  alumno.getCorreo() + "%"));

			Predicate[] pr = new Predicate[predicates.size()];
			predicates.toArray(pr);
			configConsulta.where(pr);

			Query update = entityManager.createQuery(configConsulta);

			entityManager.joinTransaction();
			
			update.executeUpdate();

			response.setCount(alumnoList.size());
			response.setList(alumnoList);
			response.setMessage("Alumno actualizado correctamente");
			response.setStatus("Realizado");
		} 
		else 
		{
			response.setData(null);
			response.setMessage("El grupo escrito no existe");
			response.setStatus("Ok pero no encontrado ese grupo");
		}

		entityManager.close();

		return response;
	}

}
