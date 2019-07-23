package com.wnxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.pojo.Order;
import com.wnxy.dao.OrderDao;
import com.wnxy.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	private OrderDao orderDao;
	/**
	 * 	查询所有订单 
	 */
	@Override
	public List<Order> findAll() {
		
		return orderDao.queryAll();
	}
	/**
	 * 	查询单个用户所有订单
	 */
	@Override
	public List<Order> findOrdersByUid(int uid) {
		// TODO Auto-generated method stub
		return orderDao.queryOrderByUid(uid);
	}
	/**
	 * 	支付修改订单的状态
	 */
	@Override
	public String addPayNumber(int ordernumber,int paynumber) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 	退款修改订单的状态
	 */
	@Override
	public String refund(int ordernumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
