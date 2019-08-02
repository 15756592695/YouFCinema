package com.woniu.tiket.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cinema.pojo.Movie;
import com.cinema.pojo.Schedule;
import com.woniu.tiket.service.MoviePlayService;
import com.woniu.tiket.service.MovieService;

@Controller
public class MoviePlayController {
	@Autowired
	private MoviePlayService moviePlayService;
	@Autowired
	private MovieService movieService;
	
	//添加排片
	@RequestMapping("/movieplay/add")
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
		schedule.setS_start(s_start);
		schedule.setS_end(s_end);
		schedule.setS_filmid(s_filmid);
		schedule.setS_discount(s_discount);
		schedule.setS_discount(s_discount);

		Boolean result = moviePlayService.addMoviePlay(schedule,r_name);
		if (result) {
			data = "添加成功";
		}
		return "redirect:http://127.0.0.1:8848/%E6%AF%95%E4%B8%9A/%E5%90%8E%E5%8F%B0%E7%AE%A1%E7%90%86%E5%89%8D%E7%AB%AF/playtime.html";
	}
	
	// 新增电影
		@RequestMapping("/movie/add")
		public String addMovie(@RequestParam("file") MultipartFile[] file, @RequestParam("video") MultipartFile video,
				String f_name, String f_area, Integer f_typeid, Integer f_length, String f_runtime, BigDecimal f_price,
				String f_dimension, Double f_hot, String f_performer, String f_describe) throws Exception {
			String data = "添加失败";
			Movie movie = new Movie();
			movie.setF_name(f_name);
			movie.setF_area(f_area);
			movie.setF_typeid(f_typeid);
			movie.setF_length(f_length);
			movie.setF_runtime(f_runtime);
			movie.setF_price(f_price);
			movie.setF_dimension(f_dimension);
			movie.setF_hot(f_hot);
			movie.setF_performer(f_performer);
			movie.setF_describe(f_describe);
			// 添加电影到数据库
			Boolean result = movieService.addMovie(movie, file, video);
			if (result) {
				data = "添加成功";
			}
			return "redirect:http://127.0.0.1:8848/%E6%AF%95%E4%B8%9A/%E5%90%8E%E5%8F%B0%E7%AE%A1%E7%90%86%E5%89%8D%E7%AB%AF/picture-list.html";

		}
}
