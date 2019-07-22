package com.cinema.pojo;

public class Seatrecords {
	
	
    public Seatrecords() {
		super();
	}

	public Seatrecords(Integer s_id, String s_room, Integer s_seatnumber, Integer orderid, Integer flag) {
		super();
		this.s_id = s_id;
		this.s_room = s_room;
		this.s_seatnumber = s_seatnumber;
		this.orderid = orderid;
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Seatrecords [s_id=" + s_id + ", s_room=" + s_room + ", s_seatnumber=" + s_seatnumber + ", orderid="
				+ orderid + ", flag=" + flag + "]";
	}

	private Integer s_id;

    private String s_room;

    private Integer s_seatnumber;

    private Integer orderid;

    private Integer flag;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_room() {
        return s_room;
    }

    public void setS_room(String s_room) {
        this.s_room = s_room == null ? null : s_room.trim();
    }

    public Integer getS_seatnumber() {
        return s_seatnumber;
    }

    public void setS_seatnumber(Integer s_seatnumber) {
        this.s_seatnumber = s_seatnumber;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}