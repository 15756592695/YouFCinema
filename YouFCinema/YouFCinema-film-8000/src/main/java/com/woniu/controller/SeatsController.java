package com.woniu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.interfaces.Order02Controller;
import com.cinema.pojo.Seats;
import com.woniu.service.SeatsService;

@RestController
public class SeatsController {
	@Autowired
	private SeatsService seatsService;

	
	/*
	 * 根据厅室id获取所有坐位
	 */
	@RequestMapping("/getAllSeats")
	public Map<String,Object> getAllSeats(@RequestParam(value="roomid") Integer roomid,@RequestParam(value="scheduleid") Integer scheduleid){
		System.out.println(roomid+"-----====="+scheduleid);
		Map<String,Object> map=seatsService.getAllByRid(roomid,scheduleid);
		System.out.println(map);
		return map;
	}
	/*
	 * 获取用户选中的坐位
	 */
	@RequestMapping("/chooseSeats")
	public int selectSeat(@RequestParam(value="seatstr") String seatstr,@RequestParam(value="roomid") Integer roomid,@RequestParam(value="scheduleid") Integer scheduleid) throws UnsupportedEncodingException{
		
		seatstr = URLDecoder.decode(seatstr, "UTF-8");
		int reInt=seatsService.getSelectedSeats(seatstr,roomid,scheduleid);
		return reInt;
	}
	
}
