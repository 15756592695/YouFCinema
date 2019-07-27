package com.cinema.config;


import org.springframework.stereotype.Component;

import com.cinema.dto.SeatToOrderDto;
import com.cinema.interfaces.Order02Controller;

import feign.hystrix.FallbackFactory;

@Component
public class FallbackConfig implements FallbackFactory<Order02Controller>{

	@Override
	public Order02Controller create(Throwable arg0) {
		return new Order02Controller(){
			@Override
			public SeatToOrderDto addOrder(SeatToOrderDto sto) {
				return sto;
			}

			@Override
			public String updateOrderByOnum(String o_number, String o_paynumber) {
				// TODO Auto-generated method stub
				return "服务器降级";
			}
		};
	}
	
}
