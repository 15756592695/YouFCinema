package com.woniu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.pojo.Images;
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
	public Map<String,Object> getMovieDetailById(Integer movieid) {
		Movie movie=movieDao.getMovieDtailById(movieid);//获取电影详细信息
		Images images=movieDao.getPhotosByFilmid(movieid);//电影剧照
		Map<String,Object> map=new HashMap<>();
		map.put("movie", movie);
		map.put("images", images);
		return map;
	}
	/*
	 * 根据电影名获取电影信息(non-Javadoc)
	 * @see com.woniu.service.MovieService#findFileByName(java.lang.String)
	 */
	@Override
	public Movie findFileByName(String filmName) {
		
		return movieDao.findFileByName(filmName);
	}
	
}
