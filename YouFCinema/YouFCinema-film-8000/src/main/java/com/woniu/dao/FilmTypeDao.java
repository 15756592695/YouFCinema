package com.woniu.dao;

import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Filetype;

public interface FilmTypeDao {
	//根据id查询类型名
	@Select("select t_name from filmtype where t_id=#{id}")
	public Filetype findTypeById(Integer id);
}
