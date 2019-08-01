package com.woniu.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Movie;

import org.apache.ibatis.annotations.One;



public interface MovieDao {
	@Select("select * from movie where f_flag!=0")
	@Results({
		@Result(id = true, column = "f_id", property = "f_id"),
		@Result(column="f_typeid",property="filmType",one=@One(select="com.woniu.dao.FilmTypeDao.findTypeById"))
	})
	public List<Movie> findAll();
	//根据电影id获取电影所有信息
	@Select("select * from movie where f_id=#{movieid}")
	@Results({
		@Result(id=true,column="f_id",property="f_id"),
		@Result(column="f_typeid",property="filmType",one=@One(select="com.woniu.dao.FilmTypeDao.findTypeById"))
	})
	public Movie getMovieDtailById(Integer movieid);
	
	//根据电影id获取电影名字
	@Select("select f_name,f_price from movie where f_id=#{id}")
	public Movie findNamePriceById(Integer id);
	
	//根据电影id查找电影价格
	@Select("select * from movie where f_id=#{id}")
	public Movie findPriceById(Integer id);
	
	//根据电影名获取电影信息
	@Select("select * from movie where f_name=#{filmName} and f_flag!=0")
	public Movie findFileByName(String filmName);
}
