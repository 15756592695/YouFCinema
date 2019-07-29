package com.woniu.tiket.controller;



import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cinema.pojo.Movie;
import com.woniu.tiket.service.MovieService;
import com.woniu.tiket.util.QiniuCloudUtil;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;

	// 查询所有电影
	@GetMapping("/movie/findallmovie")
	public List<Movie> findAllMovies() {
		List<Movie> movies = movieService.findAllMovies();
		return movies;
	}

	// 新增电影
	@PostMapping("/movie/add")
	public String addMovie(@RequestParam("file") MultipartFile file,@RequestParam("video") MultipartFile video,String f_name,String f_area,Integer f_typeid,
			Integer f_length, String f_runtime,BigDecimal f_price, String f_dimension,Double f_hot,String f_performer,
			String f_describe) throws IOException {
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
		// 判断图片是否为空
		if (file.isEmpty()) {
			return data;
		}

	    byte[] bytes = file.getBytes();
	    byte[] bytes2 = video.getBytes();
		String imageName = UUID.randomUUID().toString();
		String imageName2 = UUID.randomUUID().toString();
		QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
		System.out.println(imageName2);
		try {
			// 使用base64方式上传到七牛云
			String url = qiniuUtil.put64image(bytes, imageName);
			String url2 = qiniuUtil.put64image(bytes2, imageName2);
			movie.setF_picture("http://"+url);
			movie.setF_forecast("http://"+url2);
			System.out.println(movie.getF_forecast());
			// 添加电影到数据库
			Boolean result = movieService.addMovie(movie);
			if (result) {
				data = "添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	// 删除电影
	@DeleteMapping("/movie/del")
	public String delMovie(Integer id) {
		System.out.println(id);
		String data = "下架失败";
		Boolean result = movieService.delMovie(id);
		if (result) {
			data = "下架成功";
		}
		return data;
	}

	// 修改电影信息
	@PutMapping("/movie/update")
	public String updateMovie(Movie movie) {
		String data = "修改失败";
		Boolean result = movieService.updateMovieInfor(movie);
		if (result) {
			data = "修改成功";
		}
		return data;
	}
	
	//查询某个电影信息
		@GetMapping("/movie/movieinfo")
		public Movie updateMovie(Integer id) {
			System.out.println(id);
			Movie movie = movieService.movieInfo(id);
			return movie;
		}
	
	//查找电影的所有排片
		@GetMapping("/movie/findid")
		public List<Integer> findAllid(String name){
			List<Integer> ids = movieService.findAllid(name);
			return ids;			
		}
}
