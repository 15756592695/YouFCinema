package com.woniu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Movie;

import org.apache.ibatis.annotations.One;



public interface MovieDao {
	@Select("select * from movie")
	@Results({
		@Result(id = true, column = "f_id", property = "f_id"),
		@Result(column="f_typeid",property="filmType",one=@One(select="com.woniu.dao.FilmTypeDao.findTypeById"))
	})
	public List<Movie> findAll();
}
