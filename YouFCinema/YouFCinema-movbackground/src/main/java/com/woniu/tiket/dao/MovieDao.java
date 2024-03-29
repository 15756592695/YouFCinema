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
		@Result(column="f_typeid",property="filmType",one=@One(select="movieFiletype"))
	})
	public List<Movie> allMovies();
	
	@Select("select * from filmtype where t_id=#{f_typeid}")
	public Filetype movieFiletype(Integer f_typeid);
	
	/**
	 * 获取单个电影信息
	 * @return
	 */
	@Select("select * from movie where f_id=#{id} and f_flag=1")
	@Results({
		@Result(id=true,column="f_id",property="f_id"),
		@Result(column="f_typeid",property="f_typeid"),
		@Result(column="f_typeid",property="filmType",one=@One(select="movieFiletype"))
	})
	public Movie moviesInfor(Integer id);
	
	/**
	 * 根据电影名称获取排片id
	 * @param name
	 * @return
	 */
	@Select("select s_id from schedule INNER JOIN movie on schedule.s_filmid=movie.f_id where f_name=#{name}")
	public List<Integer> findAllid(String name);
}
