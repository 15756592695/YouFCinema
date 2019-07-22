package com.cinema.pojo;

import java.util.Date;
/**
 * 	电影表
 * @author 小范
 *
 */
public class Movie {
    private Integer f_id;//id

    private String f_name;//电影名字

    private Integer f_typeid;//电影类型id

    private String f_area;//上映地区

    private String f_runtime;//上映日期

    private Double f_hot;//热度

    private Double f_score;//评分

    private String f_describe;//描述

    private String f_forecast;//预告片URL

    private Long f_price;//价格

    private String f_performer;//演员

    private Date f_time;//不记得了

    private String f_picture;//电影海报

    private String f_dimension;//语言版本

    private Integer f_length;//电影时长

    private Integer f_flag;

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

    public Double getF_hot() {
        return f_hot;
    }

    public void setF_hot(Double f_hot) {
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