package com.cinema.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 产品对象
 * @author Mac Book Pro
 *
 */
public class ProductBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7374001288550821799l;
	private int id;
	private String productName;
	private String message;
	private int number;
	private double price;
	private String imgName;
	
	
	
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
