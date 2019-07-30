package com.wnxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.cinema.pojo.Order;
import com.wnxy.dto.OrderDTO;
import com.wnxy.dto.OrderSqlProvider;

@Repository
public interface OrderDao {
	
	@Select("select o_id,scheduleid,o_number,o_totalprice,o_ordertime,uid,o_ordernumber,o_paynumber,flag from `order` where flag=1")
	public List<Order> queryAll();
	
	@Select("select o_id,scheduleid,o_number,o_totalprice,o_ordertime,uid,o_ordernumber,o_paynumber,flag from `order` where uid=#{uid} and flag=1")
	public List<Order> queryOrderByUid(int uid);
	
	/**
	 * 	根据日期，订单号，支付号，用户id等查询相关订单
	 */
	public List<Order> manyQuery(OrderDTO orderDTO);
	/**
	 * 	根据排片id查询
	 */
	@Select("select o_id,scheduleid,o_number,o_totalprice,o_ordertime,uid,o_ordernumber,o_paynumber,flag from `order` where scheduleid=#{scheduleid}")
	public List<Order> oneQuery(int scheduleid);
}
