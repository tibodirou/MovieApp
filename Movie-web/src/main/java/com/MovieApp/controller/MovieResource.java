package com.MovieApp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MovieApp.dto.MovieDTO;
import com.MovieApp.model.Movie;
import com.MovieApp.serviceImpl.DirectorServiceImpl;
import com.MovieApp.serviceImpl.GenreServiceImpl;
import com.MovieApp.serviceImpl.MovieServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MovieResource {
	
	
	Logger log = LoggerFactory.getLogger(MovieResource.class);
	
	@Autowired
	private MovieServiceImpl movieService;
	@Autowired
	private DirectorServiceImpl directorService;
	@Autowired
	private GenreServiceImpl genreService;
	
	
	@RequestMapping(value="movies", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllMovies(){
		List<String> movies = new ArrayList<>();
		//File[] files = new File("C:\\Users\\Thibaud Dirou\\Desktop\\movies").listFiles(File::isDirectory);
		File[] files = new File("D:").listFiles(File::isDirectory);
		for (File filename : files) {
			movies.add(filename.getName());		
		
		}
		
		return movies;
	}
	
	@RequestMapping(value="movie/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieDTO getLivreDetails(@PathVariable Long id){
		System.out.println("dsdqfdsdqf");
		Movie movie = movieService.findOne(id);
		MovieDTO movieDTO = Converter.entityToDto(movie);
		return movieDTO;
	}
	
	@RequestMapping(value="fill", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public void fillDatabase(@RequestBody List<Movie> movies){
		for(Movie movie : movies) {
			movieService.save(movie);
		}
		
		

	}
	
	@RequestMapping(value="movie/tgt", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String fillDatabase(@PathVariable Long id){
		return "Camarche";
		

	}
	
	
	
	
	/*
	@RequestMapping(value="fill", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public void getDiskMovies() {
		
		
		File[] files = new File("C:\\Users\\Thibaud Dirou\\Desktop\\movies").listFiles();
		
		for (File filename : files) {
			Movie movie = new Movie();
			movie.setTitle(filename.getName().replaceAll(" ","+").substring(0, filename.getName().replaceAll(" ","+").lastIndexOf('.')) );
			movieService.save(movie);
		}
		
	}
	*/
}
