package com.MovieApp.service;

import java.util.List;
import java.util.Optional;

import com.MovieApp.model.Movie;


public interface MovieService {

	
	public Movie save(Movie movie);
	
	public Movie update(Movie movie);
	
	public List<Movie> findAll();
	
	public Movie findOne(Long id);
	
	public boolean exist(String title);
	
	public boolean exist(Long id);
	
	public void delete(Long id);
	
	
}

