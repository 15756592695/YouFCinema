package com.cinema.service;

import java.util.Date;
import java.util.List;


import com.cinema.pojo.Order;
import com.cinema.pojo.OrderDTO;

public interface OrderService {
	
	public String addOrder(OrderDTO orderDTO) ;
	public String cancel(Integer o_id); 
	public List<Order> findAll(Integer id);	
	//获取价格
	public String getPrice(String f_name,Date s_date,Date s_starttime,Integer number);
	

}
