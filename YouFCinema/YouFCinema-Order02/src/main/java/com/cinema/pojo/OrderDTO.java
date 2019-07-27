package com.cinema.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderDTO {
	//order表用数据
	private Integer scheduleid;//场次id，前端传参
	private Integer o_number;//电影票票数量，前端传参
	private String o_totalprice;//总价
	private Integer uid;//用户id
	private String o_ordernumber;//订单编号
	private String o_paynumber;//支付号
	private Integer flag;//订单状态0已支付，1未支付，2订单取消（退款）
	private String o_img;//二维码图片地址
	
	
	
	private String f_name;//电影名字
	private BigDecimal price;//电影单价
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date s_date;//上映日期
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date s_starttime;//开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date s_endtime;//结束时间
	private String s_room;//放映厅
	private String seat;//座次（a-a:b-b）前端将座次号合并，后台拆分解析
	
	
	private Schedule schedule;//场次（后台查询数据库）
	
	
	
	
	
	
	
	
	private List<String> test;//测试
	
	
	
	public String getO_img() {
		return o_img;
	}

	public void setO_img(String o_img) {
		this.o_img = o_img;
	}

	public Integer getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(Integer scheduleid) {
		this.scheduleid = scheduleid;
	}

	public List<String> getTest() {
		return test;
	}

	public void setTest(List<String> test) {
		this.test = test;
	}

	public String getF_name() {
		return f_name;
	}
	
	public String getS_room() {
		return s_room;
	}

	public void setS_room(String s_room) {
		this.s_room = s_room;
	}

	

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public Date getS_starttime() {
		return s_starttime;
	}
	public void setS_starttime(Date s_starttime) {
		this.s_starttime = s_starttime;
	}
	public Date getS_endtime() {
		return s_endtime;
	}
	public void setS_endtime(Date s_endtime) {
		this.s_endtime = s_endtime;
	}
	
	public Integer getO_number() {
		return o_number;
	}
	public void setO_number(Integer o_number) {
		this.o_number = o_number;
	}
	
	public String getO_totalprice() {
		return o_totalprice;
	}

	public void setO_totalprice(String o_totalprice) {
		this.o_totalprice = o_totalprice;
	}

	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getO_ordernumber() {
		return o_ordernumber;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setO_ordernumber(String o_ordernumber) {
		this.o_ordernumber = o_ordernumber;
	}
	public String getO_paynumber() {
		return o_paynumber;
	}
	public void setO_paynumber(String o_paynumber) {
		this.o_paynumber = o_paynumber;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "OrderDTO [f_name=" + f_name + ", price=" + price + ", o_number=" + o_number + ", s_date=" + s_date
				+ ", s_starttime=" + s_starttime + ", s_endtime=" + s_endtime + ", s_room=" + s_room + ", seat=" + seat
				+ ", schedule=" + schedule + ", o_totalprice=" + o_totalprice + ", uid=" + uid + ", o_ordernumber="
				+ o_ordernumber + ", o_paynumber=" + o_paynumber + ", flag=" + flag + ", test=" + test + "]";
	}

	

	
	
	
	
	
	
	
	
	
	

}
