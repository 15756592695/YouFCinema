package com.woniu.tiket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cinema.pojo.Schedule;
import com.cinema.pojo.ScheduleDto;

public interface MoviePlayDao {
	/**
	 * 排片表中插入数据
	 * @param schedule
	 * @return
	 */
	@Insert("insert into schedule(s_filmid,s_date,s_starttime,s_endtime,s_start,s_end,s_roomid,s_discount,s_flag)"
			+ " values(#{s_filmid},#{s_date},#{s_starttime},#{s_endtime},#{s_start},#{s_end},#{s_roomid},#{s_discount},0)")
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
		
	/**
	 * 修改影片播放状态
	 * @param id
	 */
	@Update("update schedule set s_flag=0 where s_id=#{id}")
	public Boolean delSchedule(Integer id);
	
	/**
	 * 根据id查找某场电影的播放场次
	 * @param id
	 * @return
	 */
	@Select("select * from schedule where s_id=#{id}")
	public Schedule findSchedule(Integer id);
}
