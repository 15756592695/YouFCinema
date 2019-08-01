package com.wnxy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("order/findMany")
	public void queryMore(@RequestBody OrderDTO orderDto) {
		System.out.println(orderDto);
		System.out.println("进来了");
		if(orderDto.getFilmname()==null||orderDto.getFilmname().length()<1) {
			System.out.println("嘻嘻");
			//根据用户id,订单号，支付号查询
			List<Order> orders=service.findAllByMany(orderDto);
			System.out.println(orders);

		}else {
			//根据电影名称查询
			List<Integer> scheduleids =new ArrayList<Integer>();
			List<Order>	orders = service.findAllByScheduleid(scheduleids);
		}
		
	}
}
