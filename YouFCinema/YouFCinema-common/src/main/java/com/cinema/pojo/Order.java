package com.cinema.pojo;

public class Order {
    private Integer o_id;

    private Integer scheduleid;

    private Integer o_number;

    private Long o_totalprice;

    private String o_ordertime;

    private Integer uid;

    private String o_ordernumber;

    private String o_paynumber;

    private Integer flag;

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    public Integer getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Integer getO_number() {
        return o_number;
    }

    public void setO_number(Integer o_number) {
        this.o_number = o_number;
    }

    public Long getO_totalprice() {
        return o_totalprice;
    }

    public void setO_totalprice(Long o_totalprice) {
        this.o_totalprice = o_totalprice;
    }

    public String getO_ordertime() {
        return o_ordertime;
    }

    public void setO_ordertime(String o_ordertime) {
        this.o_ordertime = o_ordertime == null ? null : o_ordertime.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getO_ordernumber() {
        return o_ordernumber;
    }

    public void setO_ordernumber(String o_ordernumber) {
        this.o_ordernumber = o_ordernumber == null ? null : o_ordernumber.trim();
    }

    public String getO_paynumber() {
        return o_paynumber;
    }

    public void setO_paynumber(String o_paynumber) {
        this.o_paynumber = o_paynumber == null ? null : o_paynumber.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}