package com.MovieApp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MovieApp.model.Director;

@Repository
public class DirectorRepository {

	@PersistenceContext
	EntityManager em;
	

	public Director findById(Long id) {
		return em.find(Director.class, id);
	}
	
	
	
	@Transactional
	public Director save(Director director) {
		
		em.persist(director);

		return director;
	}
	
	@Transactional
	public void deleteById(Long id) {
		if (existsById(id)) {
			Director director = findById(id);
			em.remove(director);
		}
	}
	
	public boolean existsById(Long id) {
		return em.find(Director.class, id) != null;
	}
		
	public List<Director> findAll () {
	    return em.createQuery("SELECT d FROM Director d",Director.class).getResultList();
	}
	
	public Director update(Director director) {
		em.merge(director);
		return director;
	}
	
	
}
