package com.woniu.dao;

import org.apache.ibatis.annotations.Insert;

import com.cinema.pojo.Seats;

public interface SeatsDao {
	//将座位数据存入数据库
	@Insert("insert into seats(se_num,se_row,se_col,se_roomid) values (#{se_num},#{se_row},#{se_col},#{se_roomid})")
	boolean addRoomSeats(Seats newseat);

}
