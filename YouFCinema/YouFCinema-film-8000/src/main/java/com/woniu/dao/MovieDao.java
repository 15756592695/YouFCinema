package com.woniu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Movie;

public interface MovieDao {
	@Select("select * from movie")
	public List<Movie> findAll();
}
