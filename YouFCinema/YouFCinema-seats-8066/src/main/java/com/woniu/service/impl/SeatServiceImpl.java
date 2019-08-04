package com.woniu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.pojo.Seats;
import com.woniu.dao.SeatDao;
import com.woniu.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService{
	@Autowired
	private SeatDao seatDao;
	/*
	 * 根据厅室id获取所有坐位(non-Javadoc)
	 */
	@Override
	public List<Seats> getAllByRid(Integer roomid) {
		
		return seatDao.findSeatsByRid(roomid);
	}

}
