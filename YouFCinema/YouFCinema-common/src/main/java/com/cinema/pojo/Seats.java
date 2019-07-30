package com.cinema.pojo;

import java.io.Serializable;

public class Seats implements Serializable {
    private Integer se_id;

    private Integer se_num;//座号

    private Integer se_row;//行

    private Integer se_col;//列

    private Integer se_roomid;//厅室id

    private Integer se_flag;
    
    
    public Integer getSe_id() {
        return se_id;
    }

    public void setSe_id(Integer se_id) {
        this.se_id = se_id;
    }

    public Integer getSe_num() {
        return se_num;
    }

    public void setSe_num(Integer se_num) {
        this.se_num = se_num;
    }

    public Integer getSe_row() {
        return se_row;
    }

    public void setSe_row(Integer se_row) {
        this.se_row = se_row;
    }

    public Integer getSe_col() {
        return se_col;
    }

    public void setSe_col(Integer se_col) {
        this.se_col = se_col;
    }

    public Integer getSe_roomid() {
        return se_roomid;
    }

    public void setSe_roomid(Integer se_roomid) {
        this.se_roomid = se_roomid;
    }

    public Integer getSe_flag() {
        return se_flag;
    }

    public void setSe_flag(Integer se_flag) {
        this.se_flag = se_flag;
    }
}