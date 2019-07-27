package com.woniu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Seats;
import com.woniu.service.SeatsService;

@RestController
public class SeatsController {
	@Autowired
	private SeatsService seatsService;
	/*
	 * 添加厅室
	 */
	@RequestMapping("/addseats")
	public String addSeat(@RequestBody String seatstr) throws UnsupportedEncodingException{
		 seatstr = URLDecoder.decode(seatstr, "UTF-8");
		 String result=seatsService.setSeats(seatstr); 
		 return seatstr;
	}
	/*
	 * 根据厅室id获取所有坐位
	 */
	@RequestMapping("/getAllSeats")
	public List<Seats> getAll(Integer roomid){
		return seatsService.getAllByRid(roomid);
	}
	/*
	 * 获取用户选中的坐位
	 */
	@RequestMapping("/chooseSeats")
	public String selectSeat(@RequestParam(value="seatstr") String seatstr,@RequestParam(value="roomid") Integer roomid,@RequestParam(value="scheduleid") Integer scheduleid) throws UnsupportedEncodingException{
		System.out.println(seatstr+","+roomid+","+scheduleid);
		seatstr = URLDecoder.decode(seatstr, "UTF-8");
	/*	seatsService.getSelectedSeats(seatstr,roomid,scheduleid);*/
		return seatstr;
	}
}
