package com.woniu.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.pojo.Room;
import com.cinema.pojo.Seats;
import com.woniu.dao.RoomDao;
import com.woniu.dao.SeatsDao;
import com.woniu.service.RoomService;
@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private SeatsDao seatsDao;
	/*
	 * 添加厅室
	 */
	@Override
	public String addRoom(String seatstr, String roomname) {
		String result="ok";
		//查看厅室名是否已存在
		String rname=roomDao.findRoomByRname(roomname);
		if(rname!=null){
			return rname;
		}
		//存入新的厅室名
		boolean boo=roomDao.addRoom(roomname);
		//获取新厅室名的id
		Integer roomid=roomDao.findIdByName(roomname);
		Seats newseat=new Seats();
		//将前端传回的座位字符串拆分
		String s1 = seatstr.split("\\[\"")[1];
		String s2 = s1.split("\"\\]")[0];
		String[] seats = s2.split("\",\"");
		for (int i = 0; i < seats.length; i++) {
			String[] seat = seats[i].split("_");
			int row = Integer.parseInt(seat[0]);
			int col = Integer.parseInt(seat[1]);
			
			newseat.setSe_row(row);
			newseat.setSe_col(col);
			newseat.setSe_num(Integer.parseInt(""+row+col));
			newseat.setSe_roomid(roomid);
			//将座位数据存入数据库
			boolean resu=seatsDao.addRoomSeats(newseat);
			if(!resu){
				result="no";
			}
		}
		
		return result;
	}
	/*
	 * 获取所有厅室(non-Javadoc)
	 */
	@Override
	public List<Room> findAllRooms() {
		
		return roomDao.findAllRooms();
	}

}
