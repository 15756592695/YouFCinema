package com.woniu.tiket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.cinema.pojo.Room;
import com.cinema.pojo.Schedule;
import com.cinema.pojo.ScheduleDto;

public interface MoviePlayDao {
	/**
	 * 排片表中插入数据
	 * @param schedule
	 * @return
	 */
	@Insert("insert into schedule(s_filmid,s_date,s_date,s_starttime,s_endtime,s_start,s_end,s_roomid,s_discount)"
			+ " values(#{s_filmid},#{s_date},#{s_starttime},#{s_endtime},#{s_start},#{s_end},#{s_roomid},#{s_discount})")
	public boolean addMoviePlay(Schedule schedule);
	
	/**
	 * 根据房间名称查找对应的房间id
	 * @param roomName
	 * @return
	 */
	@Select("select r_id from room where r_name=#{roomName} and flag=1")
	public Integer findRoom(String roomName);
	
	/**
	 * 查询所有排片记录
	 * @return
	 */
	@Select("SELECT * from schedule INNER JOIN movie ON schedule.s_filmid=movie.f_id INNER JOIN room ON schedule.s_roomid=room.r_id")
	public List<ScheduleDto> findAllSchedule();
}
