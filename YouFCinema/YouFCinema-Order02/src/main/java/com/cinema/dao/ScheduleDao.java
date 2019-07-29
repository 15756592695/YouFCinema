package com.cinema.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Schedule;

public interface ScheduleDao {
	
	//根据电影id、上映日期，开始时间查找schedule
	@Select("select * from schedule where s_filmid=#{f_id} and s_date=#{s_date} and s_starttime=#{s_starttime} ")
	public Schedule findSchedule(@Param("f_id") Integer f_id,@Param("s_date")Date s_date,@Param("s_starttime")Date s_starttime);

	//根据id查roomid
	@Select("select s_roomid from schedule where s_id=#{scheduleid}")
	public int findRoomid(Integer scheduleid);

}
