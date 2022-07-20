package com.utng.controlescolar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.utng.controlescolar.dto.AlumnoDTO;
import com.utng.controlescolar.dto.AlumnoFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Ciclo;

public class AlumnoImplJpaRepository implements IAlumnoJpaRepository {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	ICicloJpaRepository cicloRepository;

	@Override
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Alumno> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Alumno> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Alumno> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Alumno> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Alumno getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Alumno> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Alumno> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Alumno> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Alumno> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Alumno> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Alumno entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Alumno> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Alumno> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Alumno> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Alumno> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Alumno> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Alumno, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ResponseGC<Alumno> BuscarAlumnoFiltro(AlumnoFiltroDTO filtro) {
//
//		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
//
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//
//		CriteriaQuery<Alumno> configConsulta = cb.createQuery(Alumno.class);
//		Root<Alumno> raizAlumno = configConsulta.from(Alumno.class);
//		configConsulta.select(raizAlumno);
//		configConsulta.where(cb.equal(raizAlumno.get("curp"), filtro.getCurp()),
//				cb.equal(raizAlumno.get("correo"), filtro.getCorreo()),
//				cb.equal(raizAlumno.get("expediente"), filtro.getExpediente()));
//
//		List<Alumno> alumno = entityManager.createQuery(configConsulta).getResultList();
//
//		if (!alumno.isEmpty()) {
//			response.setStatus("En teoría todo okay");
//			response.setCount(alumno.size());
//			response.setList(alumno);
//			response.setMessage("Consulta realizada con éxito");
//		} else {
//			response.setStatus("No encontrado");
//			response.setCount(alumno.size());
//			response.setList(null);
//			response.setData(null);
//			response.setMessage("El alumno no fue encontrado:(");
//		}
//
//		entityManager.close();
//		return response;
//	}

//	@Modifying
//	@Override
//	public ResponseGC<Alumno> SemiActualizarAlumno(AlumnoDTO alumnoDtoUpdate, Alumno alumno) {
//
//		ResponseGC<Alumno> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
//
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaUpdate<Alumno> configConsulta = cb.createCriteriaUpdate(Alumno.class);
//		Root<Alumno> raizAlumno = configConsulta.from(Alumno.class);
//		
//		List<Predicate> predicados = new ArrayList<>();
//		
//		Optional<Ciclo> optionalCiclo = cicloRepository.findById(alumnoDtoUpdate.getCiclo());
//		
//		if(!optionalCiclo.isEmpty())
//		{
//		configConsulta.set(raizAlumno.<String>get("expediente"), alumnoDtoUpdate.getExpediente())
//				.set(raizAlumno.<String>get("nombre"), alumnoDtoUpdate.getNombre())
//				.set(raizAlumno.<String>get("curp"), alumnoDtoUpdate.getCurp())
//				.set(raizAlumno.<String>get("genero"), alumnoDtoUpdate.getGenero())
//				.set(raizAlumno.<String>get("correo"), alumnoDtoUpdate.getCorreo())
//				.set(raizAlumno.<String>get("estatus"), alumnoDtoUpdate.getEstatus())
//				.set(raizAlumno.<Ciclo>get("ciclo"), optionalCiclo.get());
//		
//		predicados.add(cb.like(raizAlumno.get("expediente"), "%" +  alumno.getExpediente() + "%"));
//		predicados.add(cb.equal(raizAlumno.get("expediente"), "%" +  alumno.getExpediente() + "%"));
//		predicados.add(cb.equal(raizAlumno.get("correo"), "%" +  alumno.getCorreo() + "%"));
//
////		
////		:)		.where(cb.equal(raizAlumno.get("expediente"), "%" +  alumno.getExpediente() + "%"))
////		:)		.where(cb.equal(raizAlumno.get("curp"), "%" +  alumno.getCurp() + "%"))
////		:)		.where(cb.equal(raizAlumno.get("correo"), "%" +  alumno.getCorreo() + "%"));
//		
//		Predicate[]pr = new Predicate[predicados.size()];
//		predicados.toArray(pr);
//		configConsulta.where(pr);
//		
//        Query update = entityManager.createQuery(configConsulta);
//		
//		update.executeUpdate();
//		
//		response.setData(alumno);
//		response.setMessage("Alumno actualizado correctamente");
//		response.setStatus("Realizado");
//		}
//		else
//		{
//			response.setData(alumno);
//			response.setMessage("El ciclo escrito no existe");
//			response.setStatus("Ok pero no encontrado ese ciclo");
//		}
//
//		entityManager.close();
//		
//		return response;
//	}

}
