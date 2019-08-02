package com.woniu.dao;

import org.apache.ibatis.annotations.Select;

public interface RoomDao {
	@Select("select r_name from room where r_id=#{id} and flag=1")
	public String getNameById(Integer id);
}
