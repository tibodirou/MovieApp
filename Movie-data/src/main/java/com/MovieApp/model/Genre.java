package com.MovieApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "genre")
public class Genre {
	
	public Genre() {
		super();
	}
	
	public Genre(String name) {
		this.name = name;
	}
	
	
	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "genres",cascade=CascadeType.ALL)
	private List<Movie> movies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	
	
	
}
