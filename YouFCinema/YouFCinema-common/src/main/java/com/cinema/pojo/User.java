package com.cinema.pojo;

public class User {
    private Integer u_id;

    private String u_tel;

    private String u_password;

    private String u_role;

    private String u_headimg;

    private String u_registertime;

    private String u_nickname;

    private Integer flag;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_tel() {
        return u_tel;
    }

    public void setU_tel(String u_tel) {
        this.u_tel = u_tel == null ? null : u_tel.trim();
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password == null ? null : u_password.trim();
    }

    public String getU_role() {
        return u_role;
    }

    public void setU_role(String u_role) {
        this.u_role = u_role == null ? null : u_role.trim();
    }

    public String getU_headimg() {
        return u_headimg;
    }

    public void setU_headimg(String u_headimg) {
        this.u_headimg = u_headimg == null ? null : u_headimg.trim();
    }

    public String getU_registertime() {
        return u_registertime;
    }

    public void setU_registertime(String u_registertime) {
        this.u_registertime = u_registertime == null ? null : u_registertime.trim();
    }

    public String getU_nickname() {
        return u_nickname;
    }

    public void setU_nickname(String u_nickname) {
        this.u_nickname = u_nickname == null ? null : u_nickname.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}