package com.wnxy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.pojo.Order;
import com.wnxy.dto.OrderDTO;
import com.wnxy.service.IOrderService;

@RestController
public class OrderController {
	@Autowired
	private IOrderService service;
	/**
	 * 	查询所有订单 
	 */
	@GetMapping("order/findAll")
	public List<Order> findAll() {
		List<Order> orders=service.findAll();
		return orders;
	}
	/**
	 * 	查询单个用户所有订单
	 */
	@GetMapping("order/findAllByUid")
	public List<Order> findAllByUid(Integer uid) {
		List<Order> orders=service.findOrdersByUid(uid);
		return orders;
	}
	/**
	 * 	修改订单状态
	 */
	@GetMapping("order/updateState")
	public String updateStateById() {
		
		return "";
	}
	/**
	 * 	多条件查询订单
	 */
	@GetMapping("order/findMany")
	public void queryMore(OrderDTO orderDto) {
		System.out.println("进来了");
		if(orderDto.getFilmname()!=null||orderDto.getFilmname().length()>0) {
			List<Integer> scheduleids =new ArrayList<Integer>();
			List<Order>	orders = service.findAllByScheduleid(scheduleids);
		}else {
			List<Order> orders=service.findAllByMany(orderDto);
			System.out.println(orders);
		}
		
	}
}
