package com.woniu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Seats;

public interface SeatsDao {
	//根据厅室id获取所有坐位
	@Select("select * from seats where se_roomid=#{roomid} and se_flag=1")
	public List<Seats> getAllByRid(Integer roomid);

}
