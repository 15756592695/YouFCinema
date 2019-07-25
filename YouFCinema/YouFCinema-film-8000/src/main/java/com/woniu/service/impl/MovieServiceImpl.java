package com.woniu.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.pojo.Movie;
import com.woniu.dao.MovieDao;
import com.woniu.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDao movieDao;

	@Override
	public List<Movie> findAll() {
		
		return movieDao.findAll();
	}
	/*
	 * 根据电影id获取电影所有信息(non-Javadoc)
	 */
	@Override
	public Movie getMovieDetailById(Integer movieid) {
		
		return movieDao.getMovieDtailById(movieid);
	}
	
}