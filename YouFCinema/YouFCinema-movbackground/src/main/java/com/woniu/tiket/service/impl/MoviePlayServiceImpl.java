package com.woniu.tiket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.pojo.Schedule;
import com.cinema.pojo.ScheduleDto;
import com.woniu.tiket.dao.MoviePlayDao;
import com.woniu.tiket.service.MoviePlayService;

@Service("moviePlayService")
public class MoviePlayServiceImpl implements MoviePlayService{
	@Autowired
	private MoviePlayDao moviePlayDao;
	
	//排片表中加入数据
	@Override
	public boolean addMoviePlay(Schedule schedule,String r_name) {
		int rid = moviePlayDao.findRoom(r_name);
		schedule.setS_roomid(rid);
		boolean result = moviePlayDao.addMoviePlay(schedule);
		return result;
	}

	//查询所有排片记录
	@Override
	public List<ScheduleDto> allSchedule() {
		List<ScheduleDto> lists = moviePlayDao.findAllSchedule();
		return lists;
	}

}
