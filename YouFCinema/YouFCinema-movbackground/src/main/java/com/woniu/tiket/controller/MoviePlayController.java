package com.woniu.tiket.controller;

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
	public String addMoviePlay(String roomName,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date,String rid,
			String startDate,String endDate,String discount,String s_dimension) {
		Schedule schedule = new Schedule();
		//将年月日时分秒合并
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startTime;
		Date endTime;
		try {
			startTime = df.parse(date + startDate);
			endTime = df.parse(date + endDate);
			schedule.setS_starttime(startTime);
			schedule.setS_endtime(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String data = "添加失败";
		int s_id = Integer.parseInt(rid);
		double s_discount = Double.parseDouble(discount);	
		schedule.setS_filmid(s_id);
		schedule.setS_date(date);		
		schedule.setS_discount(s_discount);
		schedule.setS_dimension(s_dimension);
		
		Boolean result = moviePlayService.addMoviePlay(schedule, roomName);
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
