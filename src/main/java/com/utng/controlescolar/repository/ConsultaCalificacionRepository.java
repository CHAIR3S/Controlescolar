package com.utng.controlescolar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.utng.controlescolar.dto.CalificacionDTO;
import com.utng.controlescolar.dto.CalificacionFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Calificacion;
import com.utng.controlescolar.model.Materia;

@Repository
public class ConsultaCalificacionRepository implements IConsultaCalificacionRepository {

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	ICalificacionJpaRepository calificacionRepository;
	
	@Autowired
	IMateriaJpaRepository materiaRepository;
	
	@Autowired
	IAlumnoJpaRepository alumnoRepository;
	
	@Override
	@Transactional
	public ResponseGC<Calificacion> actualizarCalificacion(CalificacionDTO calificacionUpdate, CalificacionFiltroDTO filtro) {

		// Listas que usaremos
		ResponseGC<Calificacion> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		List<Predicate> predicates = new ArrayList<>();
		Integer alumno, materia;

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Calificacion> configConsulta = cb.createCriteriaUpdate(Calificacion.class);
		Root<Calificacion> raizCalificacion = configConsulta.from(Calificacion.class);

		Optional<Materia> materiaOptional = materiaRepository.findById(calificacionUpdate.getMateria());
		Optional<Alumno> alumnoOptional = alumnoRepository.findById(calificacionUpdate.getAlumno());
		
		materia = filtro.getMateria();
		alumno = filtro.getAlumno();
		
		Optional<Materia> materiaBusqueda = materiaRepository.findById(materia);
		Optional<Alumno> alumnoBusqueda = alumnoRepository.findById(alumno);
		List<Calificacion> calificacionList = calificacionRepository.findByAlumnoAndMateria(alumnoBusqueda.get(), materiaBusqueda.get());

		if (!materiaOptional.isEmpty()) {
				configConsulta.set(raizCalificacion.<Integer>get("cal1"), calificacionUpdate.getCal1());
				configConsulta.set(raizCalificacion.<Integer>get("cal2"), calificacionUpdate.getCal2());
				configConsulta.set(raizCalificacion.<Integer>get("cal3"), calificacionUpdate.getCal3());
				configConsulta.set(raizCalificacion.<Alumno>get("alumno"), alumnoOptional.get());
				configConsulta.set(raizCalificacion.<Materia>get("materia"), materiaOptional.get());

			if (alumnoBusqueda.get() != null)
			{
				predicates.add(
						cb.equal(raizCalificacion.get("materia"), filtro.getMateria()));
			}
			if (materiaBusqueda.get() != null)
			{
				predicates.add(
						cb.equal(raizCalificacion.get("alumno"), filtro.getAlumno()));
			}


			Predicate[] pr = new Predicate[predicates.size()];
			predicates.toArray(pr);
			configConsulta.where(pr);

			Query update = entityManager.createQuery(configConsulta);

			entityManager.joinTransaction();
			
			update.executeUpdate();

			response.setCount(calificacionList.size());
			response.setList(calificacionList);
			response.setMessage("Alumno actualizado correctamente");
			response.setStatus("Realizado");
		} 
		else 
		{
			response.setData(null);
			response.setMessage("La materia o alumno escrito no existe");
			response.setStatus("Ok pero no encontrado ese grupo");
		}

		entityManager.close();

		return response;
	}

}
