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

import com.utng.controlescolar.dto.MateriaDTO;
import com.utng.controlescolar.dto.MateriaFiltroDTO;
import com.utng.controlescolar.model.Alumno;
import com.utng.controlescolar.model.Calificacion;
import com.utng.controlescolar.model.Ciclo;
import com.utng.controlescolar.model.Estatus;
import com.utng.controlescolar.model.Materia;

@Repository
public class ConsultaMateriaRepository implements IConsultaMateriaRepository {

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	IEstatusJpaRepository estatusRepository;
	
	@Autowired
	ICicloJpaRepository cicloRepository;
	
	@Autowired
	IMateriaJpaRepository materiaRepository;
	
	@Override
	@Transactional
	public ResponseGC<Materia> ActualizarMateria(MateriaFiltroDTO filtro, MateriaDTO materiaUpdate) {

		// Listas que usaremos
		ResponseGC<Materia> response = new ResponseGC<>();// Inicializamos Clase Genérica ResponseGC
		List<Predicate> predicates = new ArrayList<>();
		String nombre, clave;

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Materia> configConsulta = cb.createCriteriaUpdate(Materia.class);
		Root<Materia> raizMateria = configConsulta.from(Materia.class);

		Optional<Estatus> estatusOptional = estatusRepository.findById(materiaUpdate.getEstatus());
		Optional<Ciclo> cicloOptional = cicloRepository.findById(materiaUpdate.getCiclo());
		nombre = filtro.getNombre();
		clave = filtro.getClave();
		List<Materia> materiaList = materiaRepository.findByNombreAndClave(nombre, clave);

		if (!cicloOptional.isEmpty()) {
				configConsulta.set(raizMateria.<String>get("clave"), materiaUpdate.getClave());
				configConsulta.set(raizMateria.<String>get("nombre"), materiaUpdate.getNombre());
				configConsulta.set(raizMateria.<Estatus>get("estatus"), estatusOptional.get());
				configConsulta.set(raizMateria.<Ciclo>get("ciclo"), cicloOptional.get());

			if (filtro.getNombre() != null)
			{
				predicates.add(
						cb.equal(raizMateria.get("nombre"), filtro.getNombre()));
			}
			if (filtro.getClave() != null)
			{
				predicates.add(
						cb.equal(raizMateria.get("clave"), filtro.getClave()));
			}


			Predicate[] pr = new Predicate[predicates.size()];
			predicates.toArray(pr);
			configConsulta.where(pr);

			Query update = entityManager.createQuery(configConsulta);

			entityManager.joinTransaction();
			
			update.executeUpdate();

			response.setCount(materiaList.size());
			response.setList(materiaList);
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
