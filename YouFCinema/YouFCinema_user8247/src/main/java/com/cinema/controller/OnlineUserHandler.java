package com.cinema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class OnlineUserHandler {

    @GetMapping("/OnlineUser")
    public String OnlineUser(HttpSession session){
        //这个session不得某个用户独有的，所以要加上getServletContext()从上下文读取
        return (String)session.getServletContext().getAttribute("OnlineCount");
    }

}
