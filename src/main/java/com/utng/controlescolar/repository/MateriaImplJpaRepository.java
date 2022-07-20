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
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.utng.controlescolar.dto.MateriaDTO;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Materia;

public class MateriaImplJpaRepository implements IMateriaJpaRepository {

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	ICicloJpaRepository cicloRepository;
	
	@Override
	public List<Materia> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materia> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materia> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Materia> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Materia> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Materia> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Materia> entities) {
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
	public Materia getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materia getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Materia> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Materia> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Materia> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Materia> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Materia> findById(Integer id) {
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
	public void delete(Materia entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Materia> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Materia> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Materia> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Materia> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Materia> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Materia, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materia> findByNombreAndClave(String nombre, String clave) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ResponseGC<Materia> ActualizarMateria(Materia materia, MateriaDTO materiaUpdate) {
//		
//		ResponseGC<Materia> response = new ResponseGC<>();
//		
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaUpdate<Materia> configConsulta = cb.createCriteriaUpdate(Materia.class);
//		Root<Materia> raizMateria = configConsulta.from(Materia.class);
//		
//		Optional<Ciclo> optionalCiclo = cicloRepository.findById(materiaUpdate.getCiclo());
//		
//		if(!optionalCiclo.isEmpty())
//		{
//			configConsulta.set(raizMateria.<String>get("clave"), materiaUpdate.getClave())
//			       .set(raizMateria.<String>get("nombre"), materiaUpdate.getNombre())
//			       .set(raizMateria.<Integer>get("estatus"), materiaUpdate.getEstatus())
//			       .set(raizMateria.<Ciclo>get("ciclo"), optionalCiclo.get())
//			       .where(cb.equal(raizMateria.get("clave"), materia.getClave()))
//			       .where(cb.equal(raizMateria.get("nombre"), materia.getNombre()))
//			       .where(cb.equal(raizMateria.get("id"), materia.getId()));
//			
//			Query update = entityManager.createQuery(configConsulta);
//			
//			update.executeUpdate();
//			
//			response.setData(materia);
//			response.setMessage("Materia actualizada correctamente");
//			response.setStatus("Realizado");
//		}
//		else
//		{
//			response.setData(materia);
//			response.setMessage("El ciclo escrito no existe");
//			response.setStatus("Ok pero no encontrado ese ciclo");
//		}
//		
//		entityManager.close();
//		
//		return response;
//	}

}
