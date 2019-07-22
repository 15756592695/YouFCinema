package com.cinema.pojo;

public class Seatrecords {
    private Integer s_id;

    private String s_room;

    private Integer s_seatrow;//第几排

    private Integer s_seatcol;//座号

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

    public Integer getS_seatrow() {
        return s_seatrow;
    }

    public void setS_seatrow(Integer s_seatrow) {
        this.s_seatrow = s_seatrow;
    }

    public Integer getS_seatcol() {
        return s_seatcol;
    }

    public void setS_seatcol(Integer s_seatcol) {
        this.s_seatcol = s_seatcol;
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