package com.cinema.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 排片表
 * 
 * @author 小范
 *
 */

public class Schedule implements Serializable {
    private Integer s_id;//id

	private Integer s_filmid;// 电影id

	private String s_dimension;// 电影维度

	private Date s_date;// 播放日期

	private Date s_starttime;// 放映开始时间

	private Date s_endtime;// 结束时间

	private Integer s_roomid;// 厅室id

	private Double s_discount;// 打折率

	private Integer s_flag;

	private String room;// 厅室名

	private Movie film;// 电影
	private String s_start;// 开始时间
	private String s_end;// 结束时间
	private BigDecimal price;
	@Override
	public String toString() {
		return "Schedule [s_id=" + s_id + ", s_filmid=" + s_filmid + ", s_dimension=" + s_dimension + ", s_date="
				+ s_date + ", s_starttime=" + s_starttime + ", s_endtime=" + s_endtime + ", s_roomid=" + s_roomid
				+ ", s_discount=" + s_discount + ", s_flag=" + s_flag + ", room=" + room + ", film=" + film
				+ ", s_start=" + s_start + ", s_end=" + s_end + ", price=" + price + "]";
	}
	public Schedule(Integer s_id, Integer s_filmid, String s_dimension, Date s_date, Date s_starttime, Date s_endtime,
			Integer s_roomid, Double s_discount, Integer s_flag, String room, Movie film, String s_start, String s_end,
			BigDecimal price) {
		super();
		this.s_id = s_id;
		this.s_filmid = s_filmid;
		this.s_dimension = s_dimension;
		this.s_date = s_date;
		this.s_starttime = s_starttime;
		this.s_endtime = s_endtime;
		this.s_roomid = s_roomid;
		this.s_discount = s_discount;
		this.s_flag = s_flag;
		this.room = room;
		this.film = film;
		this.s_start = s_start;
		this.s_end = s_end;
		this.price = price;
	}

	public Schedule() {
		// TODO Auto-generated constructor stub
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
	public Date getS_starttime() {
		return s_starttime;
	}
	public void setS_starttime(Date s_starttime) {
		this.s_starttime = s_starttime;
	}
	public Date getS_endtime() {
		return s_endtime;
	}
	public void setS_endtime(Date s_endtime) {
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
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Movie getFilm() {
		return film;
	}
	public void setFilm(Movie film) {
		this.film = film;
	}
	public String getS_start() {
		return s_start;
	}
	public void setS_start(String s_start) {
		this.s_start = s_start;
	}
	public String getS_end() {
		return s_end;
	}
	public void setS_end(String s_end) {
		this.s_end = s_end;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}