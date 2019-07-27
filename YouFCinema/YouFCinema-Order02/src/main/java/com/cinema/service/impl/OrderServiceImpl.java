package com.cinema.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.dao.MovieDao;
import com.cinema.dao.OrderDao;
import com.cinema.dao.ScheduleDao;
import com.cinema.dao.SeatDao;
import com.cinema.interfaces.AliPayController;
import com.cinema.pojo.Movie;
import com.cinema.pojo.Order;
import com.cinema.pojo.OrderDTO;
import com.cinema.pojo.Schedule;
import com.cinema.service.ErweiService;
import com.cinema.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private SeatDao seatDao;
	@Autowired
	private AliPayController aliPayController;
	@Autowired
	private ErweiService erweiService;

	// 新增
	@Override
	public String addOrder(OrderDTO orderDTO) {

		// 1获得电影的信息
		Movie movie = movieDao.findByName(orderDTO.getF_name());
		// 2获得场次信息
		// Schedule schedule = scheduleDao.findSchedule(movie.getF_id(),
		// orderDTO.getS_date(), orderDTO.getS_starttime());

		// 4生成订单号（利用当前毫秒数后八位）
		Date date = new Date();
		String num = date.getTime() + "";
		String ordernumber = num.substring(num.length() - 8, num.length());
		orderDTO.setO_ordernumber(ordernumber);
		System.out.println("ordernumber:" + ordernumber);
		// 5获取用户id

		// 6获取支付宝交易号
		aliPayController.pay(ordernumber, orderDTO.getF_name(), orderDTO.getO_totalprice());
		
		// 生成二维码,获取图片路径
		String path = erweiService.createPic();
		orderDTO.setO_img(path);
		// 订单插入数据库
		String result = null;
		boolean b = orderDao.addOrder(orderDTO);
		if (b) {
			result = "ok";
		}
		Integer orderid = orderDao.findIdByOrder(ordernumber);
		System.out.println("orderid" + orderid);
		//把订单id插入seatrecords
		
		return result;
	}

	// 取消订单
	@Override
	public String cancel(Integer o_id) {
		String result = null;
		boolean b = orderDao.cancel(o_id);
		if (b) {
			result = "ok";
		}
		return result;
	}

	// 查看所有订单
	@Override
	public List<Order> findAllById(Integer id) {

		List<Order> orders = orderDao.findAllById(id);
		return orders;
	}

	// 获取订单价格
	@Override
	public String getPrice(String f_name, Date s_date, Date s_starttime, Integer number) {
		// 1获得电影的id
		Movie movie = movieDao.findByName(f_name);
		// 2获得场次
		Schedule schedule = scheduleDao.findSchedule(movie.getF_id(), s_date, s_starttime);
		System.out.println(schedule);
		// 3打折计算
		BigDecimal price = movie.getF_price();// 单价
		Double discount = schedule.getS_discount();
		BigDecimal s_discount = new BigDecimal(discount + "");// 折扣
		BigDecimal num = new BigDecimal(number + "");// 数量
		BigDecimal totalprice = price.multiply(s_discount).multiply(num);// 总价
		return totalprice.toString();
	}

	//更新订单的支付宝号
	@Override
	public String updateOrderByOnum(String o_number,String o_paynumber) {
		Boolean b=orderDao.updateOrderByOnum(o_number,o_paynumber);
		String result=null;
		if(b) {
			result="ok";
		}else {
			result="false";
		}
		return result;
	}

}
