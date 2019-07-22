package com.cinema.pojo;

import java.util.Date;

public class Comment {
    private Integer c_id;

    private String c_message;

    private Integer uid;

    private Integer filmid;

    private Date c_commenttime;

    private Integer c_score;

    private Date c_deltime;

    private Integer flag;
    
    public Comment() {
		super();
	}

	public Comment(Integer c_id, String c_message, Integer uid, Integer filmid, Date c_commenttime, Integer c_score,
			Date c_deltime, Integer flag) {
		super();
		this.c_id = c_id;
		this.c_message = c_message;
		this.uid = uid;
		this.filmid = filmid;
		this.c_commenttime = c_commenttime;
		this.c_score = c_score;
		this.c_deltime = c_deltime;
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Comment [c_id=" + c_id + ", c_message=" + c_message + ", uid=" + uid + ", filmid=" + filmid
				+ ", c_commenttime=" + c_commenttime + ", c_score=" + c_score + ", c_deltime=" + c_deltime + ", flag="
				+ flag + "]";
	}

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