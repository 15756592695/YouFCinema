package com.cinema.interfaces;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.config.FallbackConfig;
import com.cinema.dto.SeatToOrderDto;


@FeignClient(name="YouFCinema-order02",fallbackFactory=FallbackConfig.class)

public interface Order02Controller {
	@RequestMapping("/showMessage")
	public SeatToOrderDto addOrder(@RequestBody SeatToOrderDto sto);
	
	/**
	 * 更新订单支付号
	 * @param o_number
	 * @param o_paynumber
	 * @return
	 */
	@PutMapping("/updateOrder/{o_number}/{o_paynumber}")
	public String updateOrderByOnum(@PathVariable("o_number")String o_number,@PathVariable("o_paynumber")String o_paynumber);
}
