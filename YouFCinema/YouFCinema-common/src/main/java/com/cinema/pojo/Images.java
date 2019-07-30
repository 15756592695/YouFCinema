package com.cinema.pojo;

public class Images {
	private Integer i_id;
	private Integer flimid;
	private String image1;
	private String image2;
	private String image3;
	private Integer flag;
	@Override
	public String toString() {
		return "Images [i_id=" + i_id + ", flimid=" + flimid + ", image1=" + image1 + ", image2=" + image2 + ", image3="
				+ image3 + ", flag=" + flag + "]";
	}
	public Images(Integer i_id, Integer flimid, String image1, String image2, String image3, Integer flag) {
		super();
		this.i_id = i_id;
		this.flimid = flimid;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.flag = flag;
	}
	public Images() {
		
	}
	public Integer getI_id() {
		return i_id;
	}
	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}
	public Integer getFlimid() {
		return flimid;
	}
	public void setFlimid(Integer flimid) {
		this.flimid = flimid;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
