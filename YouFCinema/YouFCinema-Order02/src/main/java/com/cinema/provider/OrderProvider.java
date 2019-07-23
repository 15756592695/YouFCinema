package com.cinema.provider;

import org.apache.ibatis.jdbc.SQL;

import com.cinema.pojo.Order;

public class OrderProvider {
	
	public String addOrder(Order order) {
		SQL sql=new SQL().INSERT_INTO("`order`").VALUES("scheduleid", order.getScheduleid()+"");
		if(order.getO_number()!=null&&order.getO_number().toString().length()!=0) {
			sql.VALUES("o_number", order.getO_number()+"");
		}
		if(order.getO_totalprice()!=null&&order.getO_totalprice().toString().length()!=0) {
			sql.VALUES("o_totalprice", order.getO_totalprice()+"");
		}
		
		if(order.getUid()!=null&&order.getUid().toString().length()!=0) {
			sql.VALUES("uid", order.getUid()+"");
		}
		if(order.getO_ordernumber()!=null&&order.getO_ordernumber().toString().length()!=0) {
			sql.VALUES("o_ordernumber", "'"+order.getO_ordernumber()+"'");
		}
		if(order.getO_paynumber()!=null&&order.getO_paynumber().toString().length()!=0) {
			sql.VALUES("o_paynumber", "'"+order.getO_paynumber()+"'");
		}
		if(order.getFlag()!=null&&order.getFlag().toString().length()!=0) {
			sql.VALUES("flag", order.getFlag()+"");
		}
		return sql.toString();
	}

}
