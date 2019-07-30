package com.cinema.provider;

import org.apache.ibatis.jdbc.SQL;

import com.cinema.dto.SeatToOrderDto;

public class OrderProvider {
	
	public String addOrder(SeatToOrderDto order) {
		SQL sql=new SQL().INSERT_INTO("`order`").VALUES("scheduleid", order.getScheduleid()+"");
		if(order.getO_number()!=null&&order.getO_number().toString().length()!=0) {
			sql.VALUES("o_number", order.getO_number()+"");
		}
		if(order.getPrice()!=null&&order.getPrice().toString().length()!=0) {
			sql.VALUES("o_totalprice", order.getPrice()+"");
		}
		
		if(order.getUid()!=null&&order.getUid().toString().length()!=0) {
			sql.VALUES("uid", order.getUid()+"");
		}
		if(order.getO_ordernumber()!=null&&order.getO_ordernumber().toString().length()!=0) {
			sql.VALUES("o_ordernumber", "'"+order.getO_ordernumber()+"'");
		}
		return sql.toString();
	}

}
