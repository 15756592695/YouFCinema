package com.woniu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Movie;
import com.cinema.pojo.Schedule;
import com.woniu.service.MovieService;
import com.woniu.service.ScheduleService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ScheduleService scheduleService;
	/*
	 * 获取所有电影
	 */
	@RequestMapping("/allmovies")
	public List<Movie> allMovies(){
		return movieService.findAll();
	}
	
	/*
	 * 根据电影id获取电影所有信息
	 */
	@RequestMapping("/moviedetail")
	public Movie movieDetail(Integer movieid){
		Movie movie=movieService.getMovieDetailById(movieid);
		return movie;
	}
	/*
	 * 根据日期查看当日所有影片排片情况
	 */
	@RequestMapping("/movieSchedule")
	public List<Schedule> findSchedule(Integer movieid,Integer list){
		
		List<Schedule> scheduleMap=scheduleService.findScheduleById(movieid,list);
		
		return scheduleMap;
	}
}
