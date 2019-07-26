package com.cinema.interfaces;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.config.FallbackConfig;
import com.cinema.dto.SeatToOrderDto;


@FeignClient(name="YouFCinema-order02",fallbackFactory=FallbackConfig.class)

public interface Order02Controller {
	@RequestMapping("/addOrder")
	public String addOrder(SeatToOrderDto sto);
}
