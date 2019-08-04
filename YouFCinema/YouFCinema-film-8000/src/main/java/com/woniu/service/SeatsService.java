package com.woniu.service;

import java.util.List;
import java.util.Map;

import com.cinema.pojo.Seats;

public interface SeatsService {
	
	//根据厅室id获取所有坐位
	public Map<String, Object> getAllByRid(Integer roomid, Integer scheduleid);
	//获取影院所有坐位

	//获取用户选中的坐位
	public int getSelectedSeats(String seatstr, Integer roomid, Integer scheduleid);

}
