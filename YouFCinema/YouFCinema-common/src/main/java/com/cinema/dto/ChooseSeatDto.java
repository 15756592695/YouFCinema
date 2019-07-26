package com.cinema.dto;
/*
 * 选座
 */
public class ChooseSeatDto {
	private Integer id;
	private Integer roomid;
	private Integer scheduleid;
	private Integer seatNum;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoomid() {
		return roomid;
	}
	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}
	public Integer getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(Integer scheduleid) {
		this.scheduleid = scheduleid;
	}
	public Integer getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}
	
	
}
