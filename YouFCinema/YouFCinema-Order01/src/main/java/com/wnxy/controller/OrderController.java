package com.wnxy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.interfaces.MovieIdCtronller;
import com.cinema.pojo.Order;
import com.wnxy.dto.OrderDTO;
import com.wnxy.service.IOrderService;

@RestController
public class OrderController {
	@Autowired
	private IOrderService service;
	@Autowired
	private MovieIdCtronller movie;
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
	@GetMapping("order/findAllByUid/{uid}")
	public List<Order> findAllByUid(@PathVariable("uid")Integer uid) {
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
	public List<Order> queryMore(@RequestBody OrderDTO orderDto) {
		List<Order> orders = new ArrayList<Order>();
		if(orderDto.getFilmname()==null||orderDto.getFilmname().length()<1) {
			System.out.println("嘻嘻");
			//根据用户id,订单号，支付号查询
			OrderDTO orderD = new OrderDTO();
			if(!orderDto.getStarttime().equals("")) {
				orderD.setStarttime(orderDto.getStarttime());
			}
			if(!orderDto.getEndtime().equals("")) {
				orderD.setEndtime(orderDto.getEndtime());
			}
			if(!orderDto.getOrdernumber().equals("")) {
				orderD.setOrdernumber(orderDto.getOrdernumber());
			}
			if(!orderDto.getPaynumber().equals("")) {
				orderD.setPaynumber(orderDto.getPaynumber());
			}
			if(orderDto.getUid()!=null) {
				orderD.setUid(orderDto.getUid());
			}
			orders=service.findAllByMany(orderD);
		}else {
			//根据电影名称查询
			List<Integer> scheduleids =movie.findAllid(orderDto.getFilmname());
			orders = service.findAllByScheduleid(scheduleids);
		}
		return orders;
	}
}
