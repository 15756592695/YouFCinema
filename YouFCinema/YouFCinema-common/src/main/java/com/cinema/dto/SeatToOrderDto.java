package com.cinema.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.cinema.pojo.Seats;
/*
 * 选座与订单交互DTO
 */
public class SeatToOrderDto {
	
	private String filmName;//电影名
	
	private Integer filmId;//电影id
	
	private String RoomName;//厅室名
	
	private Date date;//放映日期
	
	private Date startTime;//放映开始时间
	
	private Date endTime;//放映结束时间
	
	private String dimention;//3D，2D
	
	private BigDecimal price;//价格
	
	private List<Seats> seats;//所选座位
	
	private Integer scheduleid;
	
	
	
	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public Integer getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(Integer scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getRoomName() {
		return RoomName;
	}

	public void setRoomName(String roomName) {
		RoomName = roomName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDimention() {
		return dimention;
	}

	public void setDimention(String dimention) {
		this.dimention = dimention;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Seats> getSeats() {
		return seats;
	}

	public void setSeats(List<Seats> seats) {
		this.seats = seats;
	}
	
	
}
