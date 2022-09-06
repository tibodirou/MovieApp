package com.MovieApp.service;

import java.util.List;
import java.util.Optional;

import com.MovieApp.model.Genre;

public interface GenreService {
	
	public Genre save(Genre genre);
	
	public Genre update(Genre genre);
	
	public List<Genre> findAll();
	
	public Optional<Genre> findOne(Long id);
	
	public boolean exist(String title);
	
	public boolean exist(Long id);
	
	public void delete(Long id);
}
