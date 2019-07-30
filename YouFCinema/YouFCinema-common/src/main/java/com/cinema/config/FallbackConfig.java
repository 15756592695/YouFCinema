package com.cinema.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cinema.dto.SeatToOrderDto;
import com.cinema.interfaces.Order02Controller;
import com.cinema.pojo.Seats;

import feign.hystrix.FallbackFactory;

@Component
public class FallbackConfig implements FallbackFactory<Order02Controller>{

	@Override
	public Order02Controller create(Throwable arg0) {
		return new Order02Controller(){
			@Override
			public SeatToOrderDto addOrder(SeatToOrderDto sto) {
				sto.setFilmName("defeat");
				return sto;
			}

			@Override
			public String updateOrderByOnum(String o_number, String o_paynumber) {
				// TODO Auto-generated method stub
				return "服务器降级";
			}

			@Override
			public  List<String> findSeats(Integer scheduleid) {
				List<String> seats=new ArrayList<String>();
				String result="服务器降级";
				seats.add(result);
				return  seats;
			}
		};
	}
	
}
