package com.woniu.tiket.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cinema.pojo.Images;
import com.cinema.pojo.Movie;

/**
 * 对电影的新增，修改，删除
 * @author li
 *
 */
public interface MovieOpetationDao {
	/**
	 * 新增电影
	 * @param movie
	 */
	@Insert("insert into movie(f_name,f_typeid,f_area,f_runtime,f_hot,f_describe,f_price,f_performer,f_picture,"
			+ "f_dimension,f_length,f_forecast)"
			+ "values(#{f_name},#{f_typeid},#{f_area},#{f_runtime},#{f_hot},#{f_describe},#{f_price},#{f_performer},"
			+ "#{f_picture},#{f_dimension},#{f_length},#{f_forecast})")
	public Boolean addMovie(Movie movie);
	
	/**
	 * 查找电影id
	 * @param moviename
	 * @return
	 */
	@Select("select f_id from movie where f_name=#{moviename} and f_flag=1 or f_flag=2")
	public Integer findMovieid(String moviename);
	
	/**
	 * 将电影对应剧照存入数据库
	 * @param images
	 * @return
	 */
	@Insert("insert into images(flimid,image1,image2,image3) values(#{flimid},#{image1},#{image2},#{image3})")
	public Boolean addImages(Images images);
	
	/**
	 * 删除电影，软删除
	 * @param id
	 */
	@Update("update movie set f_flag=0 where f_id=#{id}")
	public Boolean delMovie(Integer id);
	
	/**
	 * 修改电影信息
	 * @param movie
	 */
	@Update("update movie set f_hot=#{f_hot},f_describe=#{f_describe},f_price=#{f_price} where f_id=#{f_id} and f_flag=1")
	public Boolean updateMovieInfor(Movie movie);
}
