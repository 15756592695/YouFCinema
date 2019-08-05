package com.woniu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Room;
import com.cinema.pojo.Seats;
import com.woniu.service.RoomService;
import com.woniu.service.SeatService;
@RestController
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private SeatService seatService;
	/*
	 * 添加厅室
	 */
	@RequestMapping("/addroom")
	public String addSeat(@RequestParam(value="seatstr") String seatstr,@RequestParam(value="roomname") String roomname) throws UnsupportedEncodingException{
		 seatstr = URLDecoder.decode(seatstr, "UTF-8");
		 String result=roomService.addRoom(seatstr,roomname); 
		 return result;
	}
	//获取所有厅室名
	@RequestMapping("allrooms")
	public List<Room> findAllRooms(){
		return roomService.findAllRooms();
	}
	/*
	 * 根据厅室id获取所有坐位
	 */
	@RequestMapping("/getAllSeats")
	public List<Seats> getAllSeats(@RequestParam(value="roomid") Integer roomid){
		
		List<Seats> seats=seatService.getAllByRid(roomid);
		
		return seats;
	}
}
