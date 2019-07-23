package com.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.dao.OrderDao;
import com.cinema.pojo.Order;
import com.cinema.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	//新增
	@Override
	public String addOrder(Order order) {
		/*
		 * 1选择电影（可能用到的字段f_id,f_name,f_price）movie
		 * 2选择放映日期(可能用到的字段s_id)schedule
		 * 3选择当日放映场次（放映时间s_id）schedule
		 * 4选择座位（将选择好的座位状态改为不可用s_id,flag=1表示不可用，将订单id存入seatrecord），确认厅室
		 * 5确认订单，下单付款（15min内可支付）（订单显示信息：上映日期，场次放映、结束时间（）厅室，折扣，座次，实付金额）
		 * 6电影结束后，将座位的状态改为可用（根据s_id将flag改为0）
		 */
		
		String result=null;
		boolean b =orderDao.addOrder(order);
		if(b) {
			 result="ok";
		}
		return result;
	}

	//取消订单
	@Override
	public String cancel(Integer o_id) {
		String result=null;
		boolean b =orderDao.cancel(o_id);
		if(b) {
			 result="ok";
		}
		return result;
	}

	//查看所有订单
	@Override
	public List<Order> findAll() {
		
		List<Order> orders=	orderDao.findAll();
		return orders;
	}

}
