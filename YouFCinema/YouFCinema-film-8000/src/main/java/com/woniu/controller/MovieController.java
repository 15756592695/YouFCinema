package com.woniu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Movie;
import com.woniu.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/allmovies")
	public List<Movie> allMovies(){
		return movieService.findAll();
	}
}
