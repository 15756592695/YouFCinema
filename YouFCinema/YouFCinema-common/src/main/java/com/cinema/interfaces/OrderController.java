package com.cinema.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cinema.pojo.Order;



@FeignClient(name="YouFCinema-Order01")
public interface OrderController {
	/**
	 * 	查询单个用户所有订单
	 */
	@GetMapping("order/findAllByUid")
	public List<Order> findAllByUid(Integer uid) ;
}
