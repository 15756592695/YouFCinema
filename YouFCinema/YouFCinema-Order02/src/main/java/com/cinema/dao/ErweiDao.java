package com.cinema.dao;

import org.apache.ibatis.annotations.Select;

public interface ErweiDao {
	
	//查找订单号，作为电影取票码
	@Select("select o_ordernumber from `order` where o_id=#{o_id}")
	public String findOrderById(Integer o_id);

}
