package com.wnxy.dto;



public class OrderDTO {
	private String starttime;
	private String endtime;
	private Integer uid;
	private String filmname;
	private String ordernumber;
	private String paynumber;
	
	
	public OrderDTO() {
		super();
	}


	public OrderDTO(String starttime, String endtime, Integer uid, String filmname, String ordernumber,
			String paynumber) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
		this.uid = uid;
		this.filmname = filmname;
		this.ordernumber = ordernumber;
		this.paynumber = paynumber;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getFilmname() {
		return filmname;
	}


	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}


	public String getOrdernumber() {
		return ordernumber;
	}


	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}


	public String getPaynumber() {
		return paynumber;
	}


	public void setPaynumber(String paynumber) {
		this.paynumber = paynumber;
	}


	@Override
	public String toString() {
		return "OrderDTO [starttime=" + starttime + ", endtime=" + endtime + ", uid=" + uid + ", filmname=" + filmname
				+ ", ordernumber=" + ordernumber + ", paynumber=" + paynumber + "]";
	}
		
}
