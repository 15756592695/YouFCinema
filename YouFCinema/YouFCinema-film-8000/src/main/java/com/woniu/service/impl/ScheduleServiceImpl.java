package com.woniu.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cinema.pojo.Schedule;
import com.woniu.dao.ScheduleDao;
import com.woniu.service.ScheduleService;
@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleDao scheduleDao;
	
	/*
	 * 根据日期查看当日所有影片排片情况(non-Javadoc)
	 */
	@Override
	public List<Schedule> findScheduleById(Integer movieid,Integer list) {
		Schedule schedule=new Schedule();
		schedule.setS_filmid(movieid);
		Date date=new Date();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		if(list==2){
			cal1.add(Calendar.DATE, 1);
		}else if(list==3){
			cal1.add(Calendar.DATE, 2);
		}else if(list==1){
			cal1.setTime(date);
		}
		// 将时分秒,毫秒域清零
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		schedule.setS_date(cal1.getTime());
		List<Schedule> sc=scheduleDao.findScheduleByFilmId(schedule);
		return sc;
	}
	/*
	 * 根据排片id获取具体电影的排片信息(non-Javadoc)
	 */
	@Cacheable("findSchedule")
	@Override
	public Schedule findScheduleById(Integer scheduleid) {
		return scheduleDao.findScheduleById(scheduleid);
	}

}