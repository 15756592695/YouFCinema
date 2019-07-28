package com.woniu.tiket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.pojo.Movie;
import com.woniu.tiket.dao.MovieDao;
import com.woniu.tiket.dao.MovieOpetationDao;
import com.woniu.tiket.service.MovieService;
@Service("movieService")
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private MovieOpetationDao movieOpetationDao;

	//查找所有电影
	@Override
	public List<Movie> findAllMovies() {
		List<Movie> movies = movieDao.allMovies();
		return movies;
	}

	//新增电影
	@Override
	public Boolean addMovie(Movie movie) {
		boolean result = movieOpetationDao.addMovie(movie);
		return result;
	}

	//删除电影
	@Override
	public Boolean delMovie(Integer id) {
		boolean result = movieOpetationDao.delMovie(id);
		return result;
	}

	//修改电影信息
	@Override
	public Boolean updateMovieInfor(Movie movie) {
		boolean result = movieOpetationDao.updateMovieInfor(movie);
		return result;
	}

	//查找某个电影信息
	@Override
	public Movie movieInfo(Integer id) {
		Movie movie = movieDao.moviesInfor(id);
		return movie;
	}
	
}
