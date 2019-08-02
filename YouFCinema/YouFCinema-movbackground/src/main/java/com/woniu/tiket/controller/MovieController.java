package com.woniu.tiket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Movie;
import com.cinema.pojo.Schedule;
import com.cinema.pojo.ScheduleDto;
import com.woniu.tiket.service.MoviePlayService;
import com.woniu.tiket.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private MoviePlayService moviePlayService;

	// 查询所有电影
	@GetMapping("/movie/findallmovie")
	public List<Movie> findAllMovies() {
		List<Movie> movies = movieService.findAllMovies();
		return movies;
	}

	// 删除电影
	@DeleteMapping("/movie/del")
	public Movie delMovie(Integer id) {
		String data = "下架失败";
		boolean result = movieService.delMovie(id);
		if (result) {
			data = "下架成功";
		}
		Movie movie = movieService.movieInfo(id);
		return movie;
	}

	// 修改电影信息
	@PutMapping("/movie/update")
	public String updateMovie(@RequestBody Movie movie) {
		System.out.println(movie.getF_describe());
		String data = "修改失败";
		Boolean result = movieService.updateMovieInfor(movie);
		if (result) {
			data = "修改成功";
		}
		return data;
	}
	// 查询某个电影信息
	@GetMapping("/movie/movieinfo")
	public Movie updateMovie(Integer id) {
		System.out.println(id);
		Movie movie = movieService.movieInfo(id);
		return movie;
	}

	// 查找电影的所有排片
	@GetMapping("/movie/findid/{name}")
	public List<Integer> findAllid(@PathVariable("name") String name) {
		List<Integer> ids = movieService.findAllid(name);
		return ids;
	}

	// 查找所有排片记录
	@GetMapping("/schedule/all")
	public List<ScheduleDto> allSchedule() {
		List<ScheduleDto> lists = moviePlayService.allSchedule();
		System.out.println(lists);
		return lists;

	}

	// 修改电影播放状态
	@DeleteMapping("/schedule/del")
	public Schedule delSchedule(Integer id) {
		Schedule schedule = movieService.delSchedule(id);
		return schedule;
	}
}
