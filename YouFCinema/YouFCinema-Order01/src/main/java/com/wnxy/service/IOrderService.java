package com.wnxy.service;

import java.util.List;

import com.cinema.pojo.Order;

public interface IOrderService {
	
	/**
	 * 	查询所有订单 
	 */
	public List<Order> findAll();
	/**
	 * 	查询单个用户所有订单
	 */
	public List<Order> findOrdersByUid(int uid);
	/**
	 * 	支付修改订单的状态
	 */
	public String addPayNumber(int ordernumber,int paynumber);
	/**
	 * 	退款修改订单的状态
	 */
	public String refund(int ordernumber);
}
