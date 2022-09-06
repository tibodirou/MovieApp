package com.MovieApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApp.model.Director;
import com.MovieApp.repository.DirectorRepository;

@Service
public class DirectorServiceImpl {

	@Autowired
	private DirectorRepository directorRepository;
	
	
	public Director save(Director director) {
		return directorRepository.save(director);
	}
	
	public Director update(Director director) {
		return directorRepository.update(director);
	}
	
	public List<Director> findAll(){
		return directorRepository.findAll();
	}
	
	public Director findOne(Long id) {
		return directorRepository.findById(id);
	}
	
	public boolean exist(Long id) {
		return directorRepository.existsById(id);
	}
	
	public void delete(Long id) {
		directorRepository.deleteById(id);
	}
}
