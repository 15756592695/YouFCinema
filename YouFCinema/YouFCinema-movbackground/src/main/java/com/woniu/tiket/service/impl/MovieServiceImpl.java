package com.woniu.tiket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.pojo.Movie;
import com.woniu.tiket.dao.MovieDao;
import com.woniu.tiket.service.MovieService;
@Service("movieService")
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDao movieDao;

	//查找所有电影
	@Override
	public List<Movie> findAllMovies() {
		List<Movie> movies = movieDao.allMovies();
		return movies;
	}
	
}
