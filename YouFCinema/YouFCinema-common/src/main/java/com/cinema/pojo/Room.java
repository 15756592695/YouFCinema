package com.cinema.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 	厅室表
 * @author 小范
 *
 */
public class Room implements Serializable {
    private Integer r_id;//id

    private String r_name;//厅室名字

    private Integer r_seatnumber;//座位数量

    private Integer flag;
    
    private List<Seats> seats;//该厅室的所有坐位
    
 
    public List<Seats> getSeats() {
		return seats;
	}

	public void setSeats(List<Seats> seats) {
		this.seats = seats;
	}

	public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name == null ? null : r_name.trim();
    }

    public Integer getR_seatnumber() {
        return r_seatnumber;
    }

    public void setR_seatnumber(Integer r_seatnumber) {
        this.r_seatnumber = r_seatnumber;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}