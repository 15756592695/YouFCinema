package com.cinema.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.pojo.Order;
import com.cinema.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/addOrder")
	@ApiOperation(value="增",notes="新增订单")
	/**
	 * 
	 * @param order
	 * @return
	 */
	public String addOrder(@RequestBody Order order) {
		System.out.println(order);
		String result=orderService.addOrder(order);
		return result;
	}
	
	@GetMapping("/findAll")
	@ApiOperation(value="查",notes="查看所有订单")
	/**
	 * 
	 * @return
	 */
	public List<Order> findAll(){
		List<Order> orders=orderService.findAll();
		
		return orders;
	}

	
	@PutMapping("/updateById/{o_id}")
	@ApiOperation(value="取消",notes="取消当前订单")
	/**
	 * 
	 * @param o_id
	 * @return
	 */
	public String cancel(@PathVariable Integer o_id) {
		String result=orderService.cancel(o_id);
		return result;
	}
}
