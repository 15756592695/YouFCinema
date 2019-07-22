package com.cinema.pojo;

public class Filetype {
	
	
    @Override
	public String toString() {
		return "Filetype [t_id=" + t_id + ", t_name=" + t_name + ", t_flag=" + t_flag + "]";
	}

	public Filetype() {
		super();
	}

	public Filetype(Integer t_id, String t_name, Integer t_flag) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_flag = t_flag;
	}

	private Integer t_id;

    private String t_name;

    private Integer t_flag;

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name == null ? null : t_name.trim();
    }

    public Integer getT_flag() {
        return t_flag;
    }

    public void setT_flag(Integer t_flag) {
        this.t_flag = t_flag;
    }
}