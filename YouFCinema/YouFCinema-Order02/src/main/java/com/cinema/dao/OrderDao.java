package com.cinema.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cinema.pojo.Order;
import com.cinema.provider.OrderProvider;

import aj.org.objectweb.asm.Type;

public interface OrderDao {
	
	
	//新增订单(付款)
	@InsertProvider(type=OrderProvider.class,method="addOrder")
	public boolean addOrder(Order order);
	
	//取消订单(退款)
	@Update("update `order` set flag=0 where o_id=#{o_id} ")
	public boolean cancel(Integer o_id); 
	
	//查找所有
	@Select("select * from `order` ")
	public List<Order> findAll();	
		
	

}
