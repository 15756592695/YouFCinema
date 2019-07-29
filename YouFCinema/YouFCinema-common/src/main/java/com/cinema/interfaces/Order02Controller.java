package com.cinema.interfaces;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.config.FallbackConfig;
import com.cinema.dto.SeatToOrderDto;


@FeignClient(name="YouFCinema-order02",fallbackFactory=FallbackConfig.class)

public interface Order02Controller {
	/**
	 * 从选座页面跳转至订单页面,渲染订单页面的数据
	 * @param sto
	 * @return
	 */
	@RequestMapping("/showMessage")
	public SeatToOrderDto addOrder(@RequestBody SeatToOrderDto sto);
	
	/**
	 * 查询已选座位
	 * @param scheduleid
	 * @return
	 */
	@GetMapping("/getSeats/{scheduleid}")
	public <E> List<E> findSeats(@PathVariable("scheduleid")Integer scheduleid);
	
	/**
	 * 更新订单支付号
	 * @param o_number
	 * @param o_paynumber
	 * @return
	 */
	@PutMapping("/updateOrder/{o_number}/{o_paynumber}")
	public String updateOrderByOnum(@PathVariable("o_number")String o_number,@PathVariable("o_paynumber")String o_paynumber);
}
