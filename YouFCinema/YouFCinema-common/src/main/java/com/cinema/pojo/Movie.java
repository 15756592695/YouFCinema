package com.cinema.pojo;

import java.util.Date;

public class Movie {
	
    public Movie() {
		super();
	}

	public Movie(Integer f_id, String f_name, Integer f_typeid, String f_area, String f_runtime, Integer f_hot,
			Double f_score, String f_describe, String f_forecast, Long f_price, String f_performer, Date f_time,
			String f_picture, String f_dimension, Integer f_length, Filetype filetype, Integer f_flag) {
		super();
		this.f_id = f_id;
		this.f_name = f_name;
		this.f_typeid = f_typeid;
		this.f_area = f_area;
		this.f_runtime = f_runtime;
		this.f_hot = f_hot;
		this.f_score = f_score;
		this.f_describe = f_describe;
		this.f_forecast = f_forecast;
		this.f_price = f_price;
		this.f_performer = f_performer;
		this.f_time = f_time;
		this.f_picture = f_picture;
		this.f_dimension = f_dimension;
		this.f_length = f_length;
		this.f_flag = f_flag;
		this.filetype = filetype;
	}

	@Override
	public String toString() {
		return "Movie [f_id=" + f_id + ", f_name=" + f_name + ", f_typeid=" + f_typeid + ", f_area=" + f_area
				+ ", f_runtime=" + f_runtime + ", f_hot=" + f_hot + ", f_score=" + f_score + ", f_describe="
				+ f_describe + ", f_forecast=" + f_forecast + ", f_price=" + f_price + ", f_performer=" + f_performer
				+ ", f_time=" + f_time + ", f_picture=" + f_picture + ", f_dimension=" + f_dimension + ", f_length="
				+ f_length + ", filetype=" + filetype + ", f_flag=" + f_flag + "]";
	}

	private Integer f_id;

    private String f_name;

    private Integer f_typeid;

    private String f_area;

    private String f_runtime;

    private Integer f_hot;

    private Double f_score;

    private String f_describe;

    private String f_forecast;

    private Long f_price;

    private String f_performer;

    private Date f_time;

    private String f_picture;

    private String f_dimension;

    private Integer f_length;

    private Integer f_flag;
    
    private Filetype filetype;
    
    public Filetype getFiletype() {
		return filetype;
	}

	public void setFiletype(Filetype filetype) {
		this.filetype = filetype;
	}

	public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name == null ? null : f_name.trim();
    }

    public Integer getF_typeid() {
        return f_typeid;
    }

    public void setF_typeid(Integer f_typeid) {
        this.f_typeid = f_typeid;
    }

    public String getF_area() {
        return f_area;
    }

    public void setF_area(String f_area) {
        this.f_area = f_area == null ? null : f_area.trim();
    }

    public String getF_runtime() {
        return f_runtime;
    }

    public void setF_runtime(String f_runtime) {
        this.f_runtime = f_runtime == null ? null : f_runtime.trim();
    }

    public Integer getF_hot() {
        return f_hot;
    }

    public void setF_hot(Integer f_hot) {
        this.f_hot = f_hot;
    }

    public Double getF_score() {
        return f_score;
    }

    public void setF_score(Double f_score) {
        this.f_score = f_score;
    }

    public String getF_describe() {
        return f_describe;
    }

    public void setF_describe(String f_describe) {
        this.f_describe = f_describe == null ? null : f_describe.trim();
    }

    public String getF_forecast() {
        return f_forecast;
    }

    public void setF_forecast(String f_forecast) {
        this.f_forecast = f_forecast == null ? null : f_forecast.trim();
    }

    public Long getF_price() {
        return f_price;
    }

    public void setF_price(Long f_price) {
        this.f_price = f_price;
    }

    public String getF_performer() {
        return f_performer;
    }

    public void setF_performer(String f_performer) {
        this.f_performer = f_performer == null ? null : f_performer.trim();
    }

    public Date getF_time() {
        return f_time;
    }

    public void setF_time(Date f_time) {
        this.f_time = f_time;
    }

    public String getF_picture() {
        return f_picture;
    }

    public void setF_picture(String f_picture) {
        this.f_picture = f_picture == null ? null : f_picture.trim();
    }

    public String getF_dimension() {
        return f_dimension;
    }

    public void setF_dimension(String f_dimension) {
        this.f_dimension = f_dimension == null ? null : f_dimension.trim();
    }

    public Integer getF_length() {
        return f_length;
    }

    public void setF_length(Integer f_length) {
        this.f_length = f_length;
    }

    public Integer getF_flag() {
        return f_flag;
    }

    public void setF_flag(Integer f_flag) {
        this.f_flag = f_flag;
    }
}