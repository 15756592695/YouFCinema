package com.woniu.tiket.service;

import java.util.List;

import com.cinema.pojo.Movie;

public interface MovieService {
	//查找所有电影
	public List<Movie> findAllMovies();
}
