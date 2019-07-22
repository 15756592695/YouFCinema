package com.woniu.tiket.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Filetype;
import com.cinema.pojo.Movie;

public interface MovieDao {
	/**
	 * 查找所有电影
	 * @return
	 */
	@Select("select * from movie")
	@Results({
		@Result(id=true,column="f_id",property="f_id"),
		@Result(column="f_typeid",property="f_typeid"),
		@Result(column="f_typeid",property="filetype",one=@One(select=""))
	})
	public List<Movie> allMovies();
	
	@Select("select * from filetype where t_id=#{f_typeid}")
	public Filetype movieFiletype(Integer f_typeid);
}
