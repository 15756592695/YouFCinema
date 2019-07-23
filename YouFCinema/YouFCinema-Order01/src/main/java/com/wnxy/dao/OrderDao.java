package com.wnxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cinema.pojo.Order;

@Repository
public interface OrderDao {
	
	@Select("select o_id,scheduleid,o_number,o_totalprice,o_ordertime,uid,o_ordernumber,o_paynumber,flag from `order` where flag=1")
	public List<Order> queryAll();
	
	@Select("select o_id,scheduleid,o_number,o_totalprice,o_ordertime,uid,o_ordernumber,o_paynumber,flag from `order` where uid=#{uid} and flag=1")
	public List<Order> queryOrderByUid(int uid);
}
