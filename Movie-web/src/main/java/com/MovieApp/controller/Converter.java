package com.MovieApp.controller;

import java.util.stream.Collectors;

import com.MovieApp.dto.MovieDTO;
import com.MovieApp.model.Genre;
import com.MovieApp.model.Movie;


public class Converter {

	public static MovieDTO entityToDto(Movie movie) {
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setId(movie.getId());
		movieDTO.setTitle(movie.getTitle());
		movieDTO.setSummary(movie.getSummary());
		movieDTO.setLanguage(movie.getLanguage());
		movieDTO.setSubtitle(movie.getSubtitle());
		movieDTO.setLanguage(movie.getLanguage());
		movieDTO.setVideo(movie.getVideo());
		movieDTO.setThumbnail(movie.getThumbnail());
		movieDTO.setScore(movie.getScore());
		movieDTO.setDirector(movie.getDirector().getName());
		movieDTO.setGenres(movie.getGenre().stream().map(Genre::getName).collect(Collectors.toList()));
		
		return movieDTO;
	}
}
