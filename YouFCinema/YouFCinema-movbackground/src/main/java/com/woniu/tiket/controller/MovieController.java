package com.woniu.tiket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Movie;
import com.woniu.tiket.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	//查询所有电影
	@GetMapping("/movie/findallmovie")
	public List<Movie> findAllMovies(){
		List<Movie> movies = movieService.findAllMovies();
		return movies;		
	}
}
