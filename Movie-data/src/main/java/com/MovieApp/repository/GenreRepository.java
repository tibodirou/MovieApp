package com.MovieApp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MovieApp.model.Genre;

@Repository
public class GenreRepository {

	@PersistenceContext
	EntityManager em;
	

	public Genre findById(Long id) {
		return em.find(Genre.class, id);
	}
	
	
	
	@Transactional
	public Genre save(Genre genre) {
		
		em.persist(genre);

		return genre;
	}
	
	@Transactional
	public void deleteById(Long id) {
		if (existsById(id)) {
			Genre genre = findById(id);
			em.remove(genre);
		}
	}
	
	public boolean existsById(Long id) {
		return em.find(Genre.class, id) != null;
	}
		
	public List<Genre> findAll () {
	    return em.createQuery("SELECT g FROM Genre g",Genre.class).getResultList();
	}
	
	public Genre update(Genre genre) {
		em.merge(genre);
		return genre;
	}
	
	
}
