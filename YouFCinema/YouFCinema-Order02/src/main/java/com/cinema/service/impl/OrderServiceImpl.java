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
import com.cinema.pojo.Movie;
import com.cinema.pojo.Order;
import com.cinema.pojo.OrderDTO;
import com.cinema.pojo.Schedule;
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

	// 新增
	@Override
	public String addOrder(OrderDTO orderDTO) {
		/*
		 * 1选择电影（可能用到的字段f_id,f_name,f_price）movie 2选择放映日期(可能用到的字段s_id)schedule
		 * 3选择当日放映场次（放映时间s_id）schedule 4选择座位，确认厅室 5确认订单，下单付款（15min内可支付）
		 * （付款成功后才生成订单，支付失败或取消不生成订单） （将选择好的座位状态改为不可用s_id,flag=1表示不可用，将订单id存入seatrecord）
		 * （订单显示信息：上映日期，场次放映、结束时间（）厅室，折扣，座次，实付金额） 6电影结束后，将该场次所有座位的状态改为可用（根据s_id将flag改为0）
		 */
		// 1获得电影的id
		Movie movie = movieDao.findByName(orderDTO.getF_name());
		// 2获得场次id
		Schedule schedule = scheduleDao.findSchedule(movie.getF_id(), orderDTO.getS_date(), orderDTO.getS_starttime());
		
		if(schedule==null) {
			return "fail";
		}
		orderDTO.setSchedule(schedule);
		// 4生成订单号（利用当前毫秒数后八位）
		Date date = new Date();
		String num = date.getTime() + "";
		String ordernumber = num.substring(num.length()-8, num.length());
		orderDTO.setO_ordernumber(ordernumber);
		System.out.println("ordernumber:"+ordernumber);
		// 5获取用户id
		// 订单插入数据库
		String result = null;
		boolean b = orderDao.addOrder(orderDTO);
		if (b) {
			result = "ok";
		}
		Integer orderid=orderDao.findIdByOrder(ordernumber);
		System.out.println("orderid"+orderid);
		
		
		//拆分座次（a-a:b-b）
		if(orderDTO.getSeat().contains(":")) {
			String[] seats=orderDTO.getSeat().split(":");
			for(int i=0;i<seats.length;i++) {
			int s_seatrow=	Integer.parseInt(seats[i].substring(0));
			int s_seatcl=Integer.parseInt(seats[i].substring(seats[i].length()-2,seats[i].length()-1));
			boolean bb =seatDao.updateSeat(orderid, orderDTO.getS_room(), s_seatrow, s_seatcl);
			System.out.println(bb);
			}
			
		}else {
			String[] seats=orderDTO.getSeat().split("-");
			int s_seatrow=	Integer.parseInt(seats[0]);
			int s_seatcl=	Integer.parseInt(seats[1]);
			boolean bb =seatDao.updateSeat(orderid, orderDTO.getS_room(), s_seatrow, s_seatcl);
			System.out.println(bb);
		}

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
	public String getPrice(String f_name, Date s_date, Date s_starttime,Integer number) {
		// 1获得电影的id
		Movie movie = movieDao.findByName(f_name);
		// 2获得场次
		Schedule schedule = scheduleDao.findSchedule(movie.getF_id(), s_date, s_starttime);
		System.out.println(schedule);
		// 3打折计算
		BigDecimal price=movie.getF_price();//单价
		Double discount = schedule.getS_discount();
		BigDecimal s_discount = new BigDecimal(discount + "");//折扣
		BigDecimal num = new BigDecimal(number + "");//数量
		BigDecimal totalprice = price.multiply(s_discount).multiply(num);//总价
		return totalprice.toString();
	}

}
