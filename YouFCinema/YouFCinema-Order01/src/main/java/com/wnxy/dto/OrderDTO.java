package com.wnxy.dto;

import java.util.Date;

public class OrderDTO {
	private Date starttime;
	private Date endtime;
	private Integer uid;
	private Integer scheduleid;
	private String ordernumber;
	private String paynumber;
	
	
	
	public OrderDTO() {
		super();
	}
	public OrderDTO(Date starttime, Date endtime, Integer uid, Integer scheduleid, String ordernumber,
			String paynumber) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
		this.uid = uid;
		this.scheduleid = scheduleid;
		this.ordernumber = ordernumber;
		this.paynumber = paynumber;
	}
	@Override
	public String toString() {
		return "OrderDTO [starttime=" + starttime + ", endtime=" + endtime + ", uid=" + uid + ", scheduleid="
				+ scheduleid + ", ordernumber=" + ordernumber + ", paynumber=" + paynumber + "]";
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(Integer scheduleid) {
		this.scheduleid = scheduleid;
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
	
	
}
