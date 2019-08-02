package com.woniu.tiket.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cinema.pojo.Movie;
import com.cinema.pojo.Schedule;

public interface MovieService {
	//查找所有电影
	public List<Movie> findAllMovies();
	//新增电影
	public Boolean addMovie(Movie movie, MultipartFile[] file, MultipartFile video) throws Exception;
	//删除电影
	public Boolean delMovie(Integer id);
	//修改电影信息
	public Boolean updateMovieInfor(Movie movie);
	//查找某个电影的信息
	public Movie movieInfo(Integer id);
	//查找所有排片id
	public List<Integer> findAllid(String name);
	//修改电影播放状态
	public Schedule delSchedule(Integer id);
}
