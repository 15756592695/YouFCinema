package com.cinema.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface SeatDao {
	
	@Update("update seatrecords set orderid=#{orderid},flag=1 where s_room=#{s_room} and s_seatrow=#{s_seatrow} and s_seatcol=#{s_seatcol}")
	public Boolean updateSeat(@Param("orderid")Integer orderid,@Param("s_room")String s_room,@Param("s_seatrow")Integer s_seatrow,@Param("s_seatcol")Integer s_seatcol );
 
	@Select("select r_name from room where r_id=#{id}")
	public String findRoomById(Integer id);
	
	@Insert("insert seatrecords (s_room,s_seatrow,s_seatcol,orderid,flag) values(#{roomName},#{s_seatrow},#{s_seatcol},#{o_id},1)")
	public boolean insertRecords(@Param("roomName")String roomName,@Param("s_seatrow")Integer s_seatrow,@Param("s_seatcol")Integer s_seatcol,@Param("o_id")Integer o_id);
}
