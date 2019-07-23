package com.cinema.service;

import java.util.List;


import com.cinema.pojo.Order;

public interface OrderService {
	
	public String addOrder(Order order) ;
	public String cancel(Integer o_id); 
	public List<Order> findAll();	
	

}
