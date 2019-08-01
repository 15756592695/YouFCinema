package com.cinema.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cinema.dto.SeatToOrderDto;
import com.cinema.pojo.Order;
import com.cinema.pojo.Seatrecords;
import com.cinema.provider.OrderProvider;


public interface OrderDao {
	
	
	//新增订单(付款)
	@InsertProvider(type=OrderProvider.class,method="addOrder")
	public boolean addOrder(SeatToOrderDto order);
	
	//取消订单()
	@Update("update `order` set flag=2 where o_id=#{o_id} ")
	public boolean cancel(Integer o_id); 
	
	//查找用户所有的订单
	@Select("SELECT o_id,scheduleid,o_number,o_totalprice price,uid,o_ordernumber,o_paynumber,flag,s_filmid filmId,s_starttime startTime,f_name filmName,f_picture from `order` o INNER JOIN `schedule` s ON o.scheduleid=s.s_id INNER JOIN movie m on s.s_filmid=m.f_id WHERE uid=#{uid} and flag!=2")
	public List<SeatToOrderDto> findAllById(Integer id);

	//查找订单id
	@Select("select * from `order` where o_ordernumber=#{ordernumber}")
	public Order findAllByOrder(String ordernumber);

	//根据订单号修改交易号
	@Update("update `order` set o_paynumber=#{o_paynumber} , flag=1 where o_ordernumber=#{o_ordernumber}")
	public boolean updateOrderByOnum(@Param("o_ordernumber") String o_number,@Param("o_paynumber")String o_paynumber );

	//查询座次
	@Select("SELECT * FROM seatrecords WHERE orderid IN ( SELECT o_id FROM `order` WHERE scheduleid=#{scheduleid}  )")
	public List<Seatrecords> findSeats(Integer scheduleid);	
		
	
	
}
