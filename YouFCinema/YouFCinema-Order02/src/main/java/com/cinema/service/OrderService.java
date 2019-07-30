package com.cinema.service;

import java.util.List;

import com.cinema.dto.SeatToOrderDto;
import com.cinema.pojo.Seats;

public interface OrderService {
	
	public String addOrder(SeatToOrderDto orderDTO) ;
	public String cancel(Integer o_id); 
	public List<SeatToOrderDto> findAllById(Integer id);	
	//获取价格
//	public String getPrice(String f_name,Date s_date,Date s_starttime,Integer number);
	//添加支付号
	public String updateOrderByOnum(String o_number,String o_paynumber);
	
	public String test();
	//查座次，common类的接口
	public List<Seats> findSeats(Integer scheduleid);

}
