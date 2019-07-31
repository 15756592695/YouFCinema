package com.cinema.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface SeatDao {
	
	@Update("update seatrecords set orderid=#{orderid},flag=1 where s_room=#{s_room} and s_seatrow=#{s_seatrow} and s_seatcol=#{s_seatcol}")
	public Boolean updateSeat(@Param("orderid")Integer orderid,@Param("s_room")String s_room,@Param("s_seatrow")Integer s_seatrow,@Param("s_seatcol")Integer s_seatcol );
 
	@Select("select r_name from room where r_id=#{id}")
	public String findRoomById(Integer id);
}
