package com.woniu.tiket.service;

import java.util.List;

import com.cinema.pojo.Schedule;
import com.cinema.pojo.ScheduleDto;

public interface MoviePlayService {
	//排片
	public boolean addMoviePlay(Schedule schedule,String r_name);
	
	//所有排列记录
	public List<ScheduleDto> allSchedule();
}
