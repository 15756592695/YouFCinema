package com.woniu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;
import com.cinema.pojo.Schedule;

public interface ScheduleDao {
	//根据日期查看当日所有影片排片情况(non-Javadoc)
	@Select("select * from schedule where s_filmid=#{s_filmid} and s_date=#{s_date} and s_flag=1")
	@Results({
		@Result(id=true,column="s_id",property="s_id"),
		@Result(column="s_roomid",property="room",one=@One(select="com.woniu.dao.RoomDao.getNameById"))
	})
	public List<Schedule> findScheduleById(Schedule schedule);

}
