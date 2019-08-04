package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.interfaces.CommentController;
import com.cinema.pojo.Comment;
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
	
	@Autowired
	private CommentController commentController;
	/*
	 * 获取所有电影
	 */
	@RequestMapping("/allmovies")
	public List<Movie> allMovies(){
		return movieService.findAll();
	}
	/*
	 * 根据电影名获取电影信息
	 */
	@RequestMapping("/findFileByName")
	public Movie findFileByName(String filmName){
	
		return movieService.findFileByName(filmName);
	}
	  
	/*
	 * 根据电影id获取电影所有信息
	 */
	@RequestMapping("/moviedetail")
	public Map<String,Object> movieDetail(Integer movieid){
		Map<String,Object> map=new HashMap<>();
		//获取电影详情
		Map<String,Object> movie=movieService.getMovieDetailById(movieid);
		//获取电影的评论
		List<Comment> comments=commentController.findAllById(movieid);
	/*	List<Comment> comments=null;*/
		//存进map
		map.put("movie",movie.get("movie") );
		map.put("images", movie.get("images"));
		map.put("comments", comments);
		return map;
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
