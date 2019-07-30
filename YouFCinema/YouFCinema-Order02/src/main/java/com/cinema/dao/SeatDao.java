package com.cinema.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface SeatDao {
	
	@Update("update seatrecords set orderid=#{orderid},flag=1 where s_room=#{s_room} and s_seatrow=#{s_seatrow} and s_seatcl=#{s_seatcl}  ")
	public Boolean updateSeat(Integer orderid,String s_room,Integer s_seatrow,Integer s_seatcl );
 
	@Select("select r_name from room where r_id=#{id}")
	public String findRoomById(Integer id);
}
