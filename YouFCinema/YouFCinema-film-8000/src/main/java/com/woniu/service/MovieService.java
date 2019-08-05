package com.woniu.service;

import java.util.List;
import java.util.Map;

import com.cinema.pojo.Movie;

public interface MovieService {
	public List<Movie> findAll();
	//根据电影id获取电影所有信息
	public Map<String, Object> getMovieDetailById(Integer movieid);
	//根据电影名获取电影信息
	public Movie findFileByName(String findFileByName);
}
