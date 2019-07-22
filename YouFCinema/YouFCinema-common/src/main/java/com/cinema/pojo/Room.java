package com.cinema.pojo;

public class Room {
    private Integer r_id;

    private String r_name;

    private Integer r_seatnumber;

    private Integer flag;

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