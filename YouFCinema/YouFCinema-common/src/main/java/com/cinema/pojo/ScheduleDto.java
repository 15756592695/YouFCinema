package com.cinema.pojo;

import java.util.Date;
/**
 * 	排片表
 * @author 小范
 *
 */
public class ScheduleDto {
    private Integer s_id;//id
    
    private String f_name;//电影名称
    
    private Integer s_filmid;//电影id

    private Date s_date;//播放日期

    private String s_start;//放映时间

    private String s_end;//结束时间

    private Integer s_roomid;//厅室号
    
    private String r_name;//房间名称
    
    private Double s_discount;//打折率

    private String s_dimension;
    
    private Integer s_flag;

	@Override
	public String toString() {
		return "ScheduleDto [s_id=" + s_id + ", f_name=" + f_name + ", s_filmid=" + s_filmid + ", s_date=" + s_date
				+ ", s_start=" + s_start + ", s_end=" + s_end + ", s_roomid=" + s_roomid + ", r_name=" + r_name
				+ ", s_discount=" + s_discount + ", s_dimension=" + s_dimension + ", s_flag=" + s_flag + "]";
	}

	public ScheduleDto(Integer s_id, String f_name, Integer s_filmid, Date s_date, String s_start, String s_end,
			Integer s_roomid, String r_name, Double s_discount, String s_dimension, Integer s_flag) {
		super();
		this.s_id = s_id;
		this.f_name = f_name;
		this.s_filmid = s_filmid;
		this.s_date = s_date;
		this.s_start = s_start;
		this.s_end = s_end;
		this.s_roomid = s_roomid;
		this.r_name = r_name;
		this.s_discount = s_discount;
		this.s_dimension = s_dimension;
		this.s_flag = s_flag;
	}

	public ScheduleDto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getS_id() {
		return s_id;
	}

	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public Integer getS_filmid() {
		return s_filmid;
	}

	public void setS_filmid(Integer s_filmid) {
		this.s_filmid = s_filmid;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
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

	public Integer getS_roomid() {
		return s_roomid;
	}

	public void setS_roomid(Integer s_roomid) {
		this.s_roomid = s_roomid;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public Double getS_discount() {
		return s_discount;
	}

	public void setS_discount(Double s_discount) {
		this.s_discount = s_discount;
	}

	public String getS_dimension() {
		return s_dimension;
	}

	public void setS_dimension(String s_dimension) {
		this.s_dimension = s_dimension;
	}

	public Integer getS_flag() {
		return s_flag;
	}

	public void setS_flag(Integer s_flag) {
		this.s_flag = s_flag;
	}
	
}