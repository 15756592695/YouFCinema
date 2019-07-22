package com.cinema.pojo;

import java.util.Date;

public class Schedule {
	
	
    public Schedule() {
		super();
	}

	public Schedule(Integer s_id, Integer s_filmid, Date s_date, Date s_starttime, Date s_endtime, Integer s_roomid,
			Double s_discount, Integer s_flag) {
		super();
		this.s_id = s_id;
		this.s_filmid = s_filmid;
		this.s_date = s_date;
		this.s_starttime = s_starttime;
		this.s_endtime = s_endtime;
		this.s_roomid = s_roomid;
		this.s_discount = s_discount;
		this.s_flag = s_flag;
	}

	@Override
	public String toString() {
		return "Schedule [s_id=" + s_id + ", s_filmid=" + s_filmid + ", s_date=" + s_date + ", s_starttime="
				+ s_starttime + ", s_endtime=" + s_endtime + ", s_roomid=" + s_roomid + ", s_discount=" + s_discount
				+ ", s_flag=" + s_flag + "]";
	}

	private Integer s_id;

    private Integer s_filmid;

    private Date s_date;

    private Date s_starttime;

    private Date s_endtime;

    private Integer s_roomid;

    private Double s_discount;

    private Integer s_flag;

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
}