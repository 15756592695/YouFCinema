package com.woniu.service;

import java.util.List;
import java.util.Map;

import com.cinema.pojo.Schedule;

public interface ScheduleService {
	//根据日期查看当日所有影片排片情况
	List<Schedule> findScheduleById(Integer movieid, Integer list);
	
}
