package com.woniu.tiket.service;

import java.util.List;

import com.cinema.pojo.Movie;

public interface MovieService {
	//查找所有电影
	public List<Movie> findAllMovies();
	//新增电影
	public Boolean addMovie(Movie movie);
	//删除电影
	public Boolean delMovie(Integer id);
	//修改电影信息
	public Boolean updateMovieInfor(Movie movie);
	//查找某个电影的信息
	public Movie movieInfo(Integer id);
}
