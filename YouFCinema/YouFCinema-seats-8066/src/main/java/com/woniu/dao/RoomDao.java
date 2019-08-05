package com.woniu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Room;

public interface RoomDao {
	//根据厅室名查看该厅室名是否已存在
	@Select("select r_name from room where r_name=#{roomname} and flag=1")
	public String findRoomByRname(String roomname);
	//添加新的厅室
	@Insert("insert into room(r_name) values (#{roomname})")
	public boolean addRoom(String roomname);
	//获取新厅室名的id
	@Select("select r_id from room where r_name=#{roomname}")
	public Integer findIdByName(String roomname);
	//获取所有厅室
	@Select("select r_id,r_name from room where flag=1")
	public List<Room> findAllRooms();
	
}
