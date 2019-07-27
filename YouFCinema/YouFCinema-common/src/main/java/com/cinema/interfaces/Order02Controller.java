package com.cinema.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name=" YouFCinema-order02")
public interface Order02Controller {
	
	
	/**
	 * 更新订单支付号
	 * @param o_number
	 * @param o_paynumber
	 * @return
	 */
	@PutMapping("/updateOrder/{o_number}/{o_paynumber}")
	public String updateOrderByOnum(@PathVariable("o_number")String o_number,@PathVariable("o_paynumber")String o_paynumber);

}
