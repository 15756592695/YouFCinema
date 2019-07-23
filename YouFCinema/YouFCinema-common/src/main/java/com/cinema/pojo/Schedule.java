package com.cinema.pojo;

import java.util.Date;
/**
 * 	排片表
 * @author 小范
 *
 */
public class Schedule {
    private Integer s_id;//id

    private Integer s_filmid;//电影id
    
    private String s_dimension;//电影维度

    private Date s_date;//播放日期

    private String s_starttime;//放映时间

    private String s_endtime;//结束时间

    private Integer s_roomid;//厅室id

    private Double s_discount;//打折率

    private Integer s_flag;
    
    private String room;//厅室名
    
    

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Integer getS_id() {
		return s_id;
	}

	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}

	public Integer getS_filmid() {
		return s_filmid;
	}

	public void setS_filmid(Integer s_filmid) {
		this.s_filmid = s_filmid;
	}

	public String getS_dimension() {
		return s_dimension;
	}

	public void setS_dimension(String s_dimension) {
		this.s_dimension = s_dimension;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public String getS_starttime() {
		return s_starttime;
	}

	public void setS_starttime(String s_starttime) {
		this.s_starttime = s_starttime;
	}

	public String getS_endtime() {
		return s_endtime;
	}

	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}

	public Integer getS_roomid() {
		return s_roomid;
	}

	public void setS_roomid(Integer s_roomid) {
		this.s_roomid = s_roomid;
	}

	public Double getS_discount() {
		return s_discount;
	}

	public void setS_discount(Double s_discount) {
		this.s_discount = s_discount;
	}

	public Integer getS_flag() {
		return s_flag;
	}

	public void setS_flag(Integer s_flag) {
		this.s_flag = s_flag;
	}
    
    
    
}