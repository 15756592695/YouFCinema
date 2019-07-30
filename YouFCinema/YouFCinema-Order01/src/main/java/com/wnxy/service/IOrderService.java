package com.wnxy.service;

import java.util.List;

import com.cinema.pojo.Order;
import com.wnxy.dto.OrderDTO;

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
	
	/**
	 * 	根据(开始时间,结束时间,用户id,订单号,支付号)查询订单
	 */
	public List<Order> findAllByMany(OrderDTO orderDTO);
	/**
	 * 	根据所有排片id查询订单
	 */
	public List<Order> findAllByScheduleid(List<Integer> scheduleids);
}
