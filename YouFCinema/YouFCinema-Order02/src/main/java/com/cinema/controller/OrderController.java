package com.cinema.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.interfaces.AliPayController;
import com.cinema.pojo.Order;
import com.cinema.pojo.OrderDTO;
import com.cinema.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private AliPayController aliPayController;
	
	
	@GetMapping("/test")
	@ApiOperation(value="测试",notes="测试")
	/**
	 * 
	 * @param order
	 * @return
	 */
	public String test(String out_trade_no ,String subject,String total_amount) {
		String num=aliPayController.pay(out_trade_no, subject, total_amount);
		System.out.println(num);
		return num;
	}
	
	@PostMapping("/addOrder")
	@ApiOperation(value="增",notes="新增订单")
	/**
	 * 
	 * @param order
	 * @return
	 */
	public String addOrder(OrderDTO orderDTO) {
		System.out.println(orderDTO);
		String result=orderService.addOrder(orderDTO);
		return result;
	}
	
	@GetMapping("/findAllById/{id}")
	@ApiOperation(value="查",notes="查看用户所有订单")
	/**
	 * 
	 * @return
	 */
	public List<Order> findAllById(@PathVariable("id")Integer id){
		List<Order> orders=orderService.findAllById(id);
		
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
	
	
	/**
	 * 付款价格
	 * @param f_name
	 * @param s_date
	 * @param s_starttime
	 * @return
	 */
	@GetMapping("/getprice")
	@ApiOperation(value="总价",notes="获取当前总价")
	public String getPrice(OrderDTO orderDTO) {
		
		String price=orderService.getPrice(orderDTO.getF_name(), orderDTO.getS_date(), orderDTO.getS_starttime(), orderDTO.getO_number());
		System.out.println("price"+price);
		return price;
	}
}
