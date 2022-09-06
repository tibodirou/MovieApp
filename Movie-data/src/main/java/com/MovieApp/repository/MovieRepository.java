package com.MovieApp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MovieApp.model.Movie;


@Repository
public class MovieRepository {

	@PersistenceContext
	EntityManager em;
	

	public Movie findById(Long id) {
		return em.find(Movie.class, id);
	}
	
	
	
	@Transactional
	public Movie save(Movie movie) {
		
		em.persist(movie);

		return movie;
	}
	
	@Transactional
	public void deleteById(Long id) {
		if (existsById(id)) {
			Movie movie = findById(id);
			em.remove(movie);
		}
	}
	
	public boolean existsById(Long id) {
		return em.find(Movie.class, id) != null;
	}
		
	public List<Movie> findAll () {
	    return em.createQuery("SELECT m FROM Movie m",Movie.class).getResultList();
	}
	
	public Movie update(Movie movie) {
		em.merge(movie);
		return movie;
	}
	
	
}