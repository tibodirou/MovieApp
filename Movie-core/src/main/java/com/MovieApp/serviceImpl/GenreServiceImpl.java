package com.MovieApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApp.model.Genre;
import com.MovieApp.repository.GenreRepository;

@Service
public class GenreServiceImpl {

	@Autowired
	private GenreRepository genreRepository;
	
	
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
	}
	
	public Genre update(Genre genre) {
		return genreRepository.update(genre);
	}
	
	public List<Genre> findAll(){
		return genreRepository.findAll();
	}
	
	public Genre findOne(Long id) {
		return genreRepository.findById(id);
	}
	
	public boolean exist(Long id) {
		return genreRepository.existsById(id);
	}
	
	public void delete(Long id) {
		genreRepository.deleteById(id);
	}
}
