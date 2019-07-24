package com.cinema.dao;

import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Movie;

public interface MovieDao {
	
	
	//根据电影名字查找电影id
	@Select("select * from movie where f_name=#{name}")
	public Movie findByName(String name);

}
