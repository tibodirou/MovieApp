package com.MovieApp.service;

import java.util.List;
import java.util.Optional;

import com.MovieApp.model.Director;

public interface DirectorService {

	
	public Director save(Director director);
	
	public Director update(Director director);
	
	public List<Director> findAll();
	
	public Optional<Director> findOne(Long id);
	
	public boolean exist(String title);
	
	public boolean exist(Long id);
	
	public void delete(Long id);
	
	
}
