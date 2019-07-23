package com.woniu.tiket.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Movie;
import com.woniu.tiket.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	//查询所有电影
	@GetMapping("/movie/findallmovie")
	public List<Movie> findAllMovies(){
		List<Movie> movies = movieService.findAllMovies();
		return movies;		
	}
	
	//新增电影
	@PostMapping("/movie/add")
	public String addMovie(Movie movie) {
		String data = "添加失败";
		Boolean result = movieService.addMovie(movie);
		if (result) {
			data = "添加成功";
		}
		return data;
	}
	
	//删除电影
	@DeleteMapping("/movie/del")
	public String delMovie(Integer id) {
		String data = "下架失败";
		Boolean result = movieService.delMovie(id);
		if (result) {
			data = "下架成功";
		}
		return data;
	}
	
	//修改电影信息
	@PutMapping("/movie/update")
	public String updateMovie(Movie movie) {
		String data = "修改失败";
		Boolean result = movieService.updateMovieInfor(movie);
		if (result) {
			data = "修改成功";
		}
		return data;
	}
}
