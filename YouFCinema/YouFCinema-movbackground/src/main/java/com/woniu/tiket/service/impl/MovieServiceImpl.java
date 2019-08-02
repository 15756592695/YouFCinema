package com.woniu.tiket.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cinema.pojo.Images;
import com.cinema.pojo.Movie;
import com.cinema.pojo.Schedule;
import com.woniu.tiket.dao.MovieDao;
import com.woniu.tiket.dao.MovieOpetationDao;
import com.woniu.tiket.dao.MoviePlayDao;
import com.woniu.tiket.service.MovieService;
import com.woniu.tiket.util.QiniuCloudUtil;

@Transactional
@Service("movieService")
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private MovieOpetationDao movieOpetationDao;
	@Autowired
	private MoviePlayDao moviePlayDao;

	//查找所有电影
	@Override
	public List<Movie> findAllMovies() {
		List<Movie> movies = movieDao.allMovies();
		return movies;
	}

	//新增电影
	@Override
	public Boolean addMovie(Movie movie,MultipartFile[] file, MultipartFile video) throws Exception {
		Boolean data = false;
		
		Images images = new Images();
		QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
		for (int i = 0; i < file.length; i++) {
			byte[] bytes = file[i].getBytes();
			String imageName = UUID.randomUUID().toString();
			String url = qiniuUtil.put64image(bytes, imageName);
			switch (i) {
			case 0:
				movie.setF_picture("http://" + url);
				break;
			case 1:
				images.setImage1("http://" + url);
				break;
			case 2:
				images.setImage2("http://" + url);
				break;
			case 3:
				images.setImage3("http://" + url);
			}
		}
		byte[] bytes2 = video.getBytes();
		String imageName = UUID.randomUUID().toString();
		// 使用base64方式上传到七牛云
		String url2 = qiniuUtil.put64image(bytes2, imageName);
		movie.setF_forecast("http://" + url2);
		
		Integer f_id = movieOpetationDao.findMovieid(movie.getF_name());
		if (f_id == null) {		
			boolean result = movieOpetationDao.addMovie(movie);
			int id = movieOpetationDao.findMovieid(movie.getF_name());
			images.setFlimid(id);
			boolean res = movieOpetationDao.addImages(images);
			if (result && res) {
				data = true;
			}
			return data;
		}
		return data;
	}
	
	//删除电影
	@Override
	public Boolean delMovie(Integer id) {
		boolean result = movieOpetationDao.delMovie(id);
		return result;
	}

	//修改电影信息
	@Override
	public Boolean updateMovieInfor(Movie movie) {
		boolean result = movieOpetationDao.updateMovieInfor(movie);
		return result;
	}

	//查找某个电影信息
	@Override
	public Movie movieInfo(Integer id) {
		Movie movie = movieDao.moviesInfor(id);
		return movie;
	}

	//查找某个电影的排片
	@Override
	public List<Integer> findAllid(String name) {
		List<Integer> ids = movieDao.findAllid(name);
		return ids;
	}

	//修改电影播放状态
	@Override
	public Schedule delSchedule(Integer id) {
		moviePlayDao.delSchedule(id);	
		Schedule schedule =moviePlayDao.findSchedule(id);
		return schedule;
	}
	
}
