package com.cinema.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineCount implements HttpSessionListener {
    //统计在线人数
    public int count = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {  //加同步锁，避免统计出错
        System.out.println("session增加，在线人数+1");
        count++;
        //se.getSession().setAttribute();  这个是存到用户的session，而下面这个是可以存到上下文
        se.getSession().getServletContext().setAttribute("OnlineCount",count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session增加，在线人数-1");
        count--;
        //se.getSession().setAttribute();  这个是存到用户的session，而下面这个是可以存到上下文
        se.getSession().getServletContext().setAttribute("OnlineCount",count);
    }
}
