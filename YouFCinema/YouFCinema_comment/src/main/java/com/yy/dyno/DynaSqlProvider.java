package com.yy.dyno;

import org.apache.ibatis.jdbc.SQL;

public class DynaSqlProvider {

    public String selectWhitParamSql(String id) {
        return new SQL() {
            {
                SELECT("*");
                FROM("comment");
                if (id!=null) {
                    WHERE("id=#{id}");
                }
               WHERE("flag=0");
            }
        }.toString();
    }
}
