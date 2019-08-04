package com.woniu.service;

import java.util.List;

import com.cinema.pojo.Room;

public interface RoomService {
	//添加厅室
	public String addRoom(String seatstr, String roomname);
	//获取所有厅室
	public List<Room> findAllRooms();

}
