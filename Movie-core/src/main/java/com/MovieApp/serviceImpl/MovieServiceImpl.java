package com.MovieApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApp.model.Movie;
import com.MovieApp.repository.MovieRepository;


@Service
public class MovieServiceImpl {

	@Autowired
	private MovieRepository movieRepository;
	
	
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public Movie update(Movie movie) {
		return movieRepository.update(movie);
	}
	
	public List<Movie> findAll(){
		return movieRepository.findAll();
	}
	
	public Movie findOne(Long id) {
		return movieRepository.findById(id);
	}
	
	public boolean exist(Long id) {
		return movieRepository.existsById(id);
	}
	
	public void delete(Long id) {
		movieRepository.deleteById(id);
	}
}
