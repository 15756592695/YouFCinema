package com.wnxy.dto;

import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {
    //查询
    public String manyQuery(OrderDTO orderDto) {
    	String starttime=orderDto.getStarttime();
    	System.out.println("执行SQL语句");
        return new SQL() {{
            SELECT("o_id, scheduleid,o_number,o_totalprice,o_ordertime,uid,o_ordernumber,o_paynumber,flag)");
            FROM("`order`");
            WHERE("flag=1");
            WHERE("o_ordertime  &gt;= ${createTimeBetween}");
           /* if (orderDto != null) {
            	if (orderDto.getPaynumber() != null) {
            		WHERE("and o_ordertime = #{endtime}");
            	}
                if (orderDto.getPaynumber() != null) {
                    WHERE("o_paynumber = #{paynumber}");
                }
                if (orderDto.getOrdernumber() != null) {
                    WHERE("o_ordernumber = #{ordernumber}");
                }
                if (orderDto.getUid() != null) {
                    WHERE("uid = #{uid}");
                }
            }*/
        }}.toString();
    }
}
