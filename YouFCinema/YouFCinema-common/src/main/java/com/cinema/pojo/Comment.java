package com.cinema.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 	评论表
 * @author 小范
 *
 */
public class Comment implements Serializable {
    private Integer c_id;//id

    private String c_message;//评论信息

    private Integer uid;//用户id

    private Integer filmid;//电影id

    private Date c_commenttime;//评论时间

    private Integer c_score;//评分

    private Date c_deltime;//删除时间

    private Integer flag;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_message() {
        return c_message;
    }

    public void setC_message(String c_message) {
        this.c_message = c_message == null ? null : c_message.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFilmid() {
        return filmid;
    }

    public void setFilmid(Integer filmid) {
        this.filmid = filmid;
    }

    public Date getC_commenttime() {
        return c_commenttime;
    }

    public void setC_commenttime(Date c_commenttime) {
        this.c_commenttime = c_commenttime;
    }

    public Integer getC_score() {
        return c_score;
    }

    public void setC_score(Integer c_score) {
        this.c_score = c_score;
    }

    public Date getC_deltime() {
        return c_deltime;
    }

    public void setC_deltime(Date c_deltime) {
        this.c_deltime = c_deltime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}