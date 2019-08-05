package com.woniu.service;

import java.util.List;

import com.cinema.pojo.Seats;

public interface SeatService {
	//根据厅室id 获取所有坐位
	public List<Seats> getAllByRid(Integer roomid);

}
