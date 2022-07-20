package com.utng.controlescolar.repository;

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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.utng.controlescolar.dto.GrupoDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Grupo;

public class GrupoImplJpaRepository implements IGrupoJpaRepository {

	@Autowired
	EntityManager entityManager;

	@Autowired
	ICicloJpaRepository cicloRepository;

	@Override
	public List<Grupo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupo> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Grupo> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Grupo> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Grupo> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Grupo> entities) {
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
	public Grupo getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grupo getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Grupo> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Grupo> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Grupo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Grupo> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Grupo> findById(Integer id) {
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
	public void delete(Grupo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Grupo> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Grupo> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Grupo> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Grupo> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Grupo> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Grupo, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupo> findByGrupoAndId(String grupo, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Modifying
//	@Override
//	public ResponseGC<Grupo> ActualizarGrupo(Grupo grupo, GrupoDTO grupoUpdate) {
//		
//		ResponseGC<Grupo> response = new ResponseGC<>();
//		
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaUpdate<Grupo> configConsulta = cb.createCriteriaUpdate(Grupo.class);
//		Root<Grupo> raizGrupo = configConsulta.from(Grupo.class);
//		
//		Optional<Ciclo> optionalCiclo = cicloRepository.findById(grupoUpdate.getCiclo());
//		
//		if(!optionalCiclo.isEmpty())
//		{
//			configConsulta.set(raizGrupo.<Integer>get("id"), grupoUpdate.getId())
//			       .set(raizGrupo.<String>get("grupo"), grupoUpdate.getGrupo())
//			       .set(raizGrupo.<String>get("estatus"), grupoUpdate.getEstatus())
//			       .set(raizGrupo.<Ciclo>get("ciclo"), optionalCiclo.get())
//			       .where(cb.equal(raizGrupo.get("id"), grupo.getId()))
//			       .where(cb.equal(raizGrupo.get("grupo"), grupo.getEstatus()))
//			       .where(cb.equal(raizGrupo.get("estatus"), grupo.getEstatus()));
//			
//			Query update = entityManager.createQuery(configConsulta);
//			
//			update.executeUpdate();
//			
//			response.setData(grupo);
//			response.setMessage("Grupo actualizado correctamente");
//			response.setStatus("Realizado");
//		}
//		else
//		{
//			response.setData(grupo);
//			response.setMessage("El ciclo escrito no existe");
//			response.setStatus("Ok pero no encontrado ese ciclo");
//		}
//		
//		entityManager.close();
//		
//		return response;
//	}

}
