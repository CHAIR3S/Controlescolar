package com.utng.controlescolar.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.utng.controlescolar.dto.CicloFiltroDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Periodo;
import com.utng.controlescolar.model.Estatus;


public class CicloImplJpaRepository implements ICicloJpaRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Ciclo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciclo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciclo> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ciclo> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Ciclo> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ciclo> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Ciclo> entities) {
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
	public Ciclo getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciclo getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ciclo> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ciclo> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Ciclo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ciclo> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ciclo> findById(Integer id) {
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
	public void delete(Ciclo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Ciclo> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Ciclo> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Ciclo> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ciclo> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Ciclo> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Ciclo, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciclo> findByCicloAndClave(String ciclo, String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseGC<Ciclo> ActualizarCiclo(Ciclo ciclo, Ciclo cicloUpdate){

		ResponseGC<Ciclo> response = new ResponseGC<>();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Ciclo> configConsulta = cb.createCriteriaUpdate(Ciclo.class);
		Root<Ciclo> raizCiclo = configConsulta.from(Ciclo.class);

		configConsulta.set(raizCiclo.<Integer>get("id"), cicloUpdate.getId())
				.set(raizCiclo.<String>get("clave"), cicloUpdate.getClave())
				.set(raizCiclo.<String>get("ciclo"), cicloUpdate.getCiclo())
				.set(raizCiclo.<Estatus>get("estatus"), cicloUpdate.getEstatus())
				.set(raizCiclo.<Periodo>get("periodo"), cicloUpdate.getPeriodo())
				.set(raizCiclo.<Date>get("fechaInicio"), cicloUpdate.getFechaInicio())
				.set(raizCiclo.<Date>get("fechaFin"), cicloUpdate.getFechaFin())
				
				.where(cb.equal(raizCiclo.get("id"), ciclo.getId()))
				.where(cb.equal(raizCiclo.get("clave"), ciclo.getClave()))
				.where(cb.equal(raizCiclo.get("ciclo"), ciclo.getCiclo()))
				.where(cb.equal(raizCiclo.get("estatus"), ciclo.getEstatus()))
				.where(cb.equal(raizCiclo.get("periodo"), ciclo.getPeriodo()));

		Query update = entityManager.createQuery(configConsulta);
		
		update.executeUpdate();
		
		entityManager.close();
		
		response.setData(ciclo);
		response.setList(null);
		response.setMessage("Ciclo actualizado correctamente");
		response.setStatus("Okisin");

		return response;
	}

}
