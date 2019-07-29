package com.woniu.tiket.controller;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Schedule;
import com.cinema.pojo.ScheduleDto;
import com.woniu.tiket.service.MoviePlayService;

@RestController
public class MoviePlayController {
	@Autowired
	private MoviePlayService moviePlayService;
	
	//添加排片
	@PostMapping("/movieplay/add")
	public String addMoviePlay(String r_name,@DateTimeFormat(pattern = "yyyy-MM-dd") Date s_date,Integer s_filmid,
			String s_start,String s_end,Double s_discount) throws ParseException {
		String data = "添加失败";
		Schedule schedule = new Schedule();
		//将年月日时分秒合并
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
		String start = new SimpleDateFormat("yyyy-MM-dd ").format(s_date);
		String startTime1 = start+s_start;
		String endTime1 = start+s_end;
		Date startTime = df.parse(startTime1);
		Date endTime = df.parse(endTime1);
		//将数据加入对象
		schedule.setS_date(s_date);
		schedule.setS_starttime(startTime);
		schedule.setS_endtime(endTime);
		schedule.setS_filmid(s_filmid);
		schedule.setS_discount(s_discount);
		schedule.setS_discount(s_discount);

		Boolean result = moviePlayService.addMoviePlay(schedule);
		if (result) {
			data = "添加成功";
		}
		return data;
	}
	
	//查找所有排片记录
	@GetMapping("/schedule/all")
	public List<ScheduleDto> allSchedule(){
		List<ScheduleDto> lists = moviePlayService.allSchedule();
		System.out.println(lists);
		return lists;
		
	}
}
