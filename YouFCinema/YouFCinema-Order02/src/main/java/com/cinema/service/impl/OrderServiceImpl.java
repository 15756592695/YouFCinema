package com.cinema.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.cinema.dao.OrderDao;
import com.cinema.dao.ScheduleDao;
import com.cinema.dao.SeatDao;
import com.cinema.dto.SeatToOrderDto;
import com.cinema.interfaces.AliPayController;
import com.cinema.pojo.Order;
import com.cinema.pojo.Seatrecords;
import com.cinema.pojo.Seats;
import com.cinema.service.OrderService;
import com.cinema.util.RedisUtil;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private SeatDao seatDao;
	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private AliPayController aliPayController;
	@Autowired
	private RedisUtil redisUtil;

	// 新增
	@Override
	// @CacheEvict(value={"findAllById"},allEntries=true)
	public String addOrder(SeatToOrderDto orderDTO) {
		String result = null;
		Order order = new Order();
		// 根据座位数获取票数
		int o_number = orderDTO.getSeats().size();
		// 生成订单号（利用当前毫秒数后八位）
		Date date = new Date();
		String num = date.getTime() + "";
		String ordernumber = num.substring(num.length() - 8, num.length());
		System.out.println("ordernumber:" + ordernumber);
		// 5获取用户id
		// 给order赋值
		order.setScheduleid(orderDTO.getScheduleid());
		order.setO_number(o_number);
		order.setO_totalprice(orderDTO.getPrice());
		Integer uid = 1;
		order.setUid(uid);// 设置用户id
		order.setO_ordernumber(ordernumber);
		// 首先，生成订单
		 orderDao.addOrder(order);
		 
		// 调用支付接口，支付方法里将支付号写入订单
		try {
			aliPayController.pay(ordernumber, orderDTO.getFilmName(), orderDTO.getPrice() + "");
		} catch (Exception e) {
			// 手动回滚
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			System.out.println("支付异常");
		} finally {
			// 判断支付是否成功
			Order neworder = orderDao.findAllByOrder(ordernumber);
			// 支付失败
			if (neworder.getFlag() != 1 || neworder == null) {
				System.out.println("支付失败");
				// 手动回滚
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				// 将订单信息存入redis，15min后取消
				String key = "findAllById::" + uid;// 1代表用户id，后期替换
				List<Order> orders = orderDao.findAllById(uid);
				orders.add(order);
				redisUtil.set(key, orders, 120l);// 设置未完成订单过期时间
				// 设置前端倒计时时间
				String time = "datetime::" + uid;// 1代表用户id，后期替换
//				redisUtil.set(time, System.currentTimeMillis() + 2 * 60 * 1000);
				result = "false";
			} else if (neworder != null && neworder.getFlag() == 1) {
				System.out.println("支付成功");
				// 把订单id插入seatrecords,flag改为1
				for (int i = 0; i < orderDTO.getSeats().size(); i++) {
					String s_room = seatDao.findRoomById(orderDTO.getSeats().get(i).getSe_roomid());
					boolean b2 = seatDao.updateSeat(neworder.getO_id(), s_room, orderDTO.getSeats().get(i).getSe_row(),
							orderDTO.getSeats().get(i).getSe_col());
				}
				// 查找该订单的缓存，把redis缓存该订单信息清除
				String key = "findAllById::" + uid;// 1代表用户id，后期替换
				if (redisUtil.hasKey(key)) {
					redisUtil.del(key);
				}
				// 倒计时数据清除
				/*String time = "datetime::" + uid;// 1代表用户id，后期替换
				if (redisUtil.hasKey(time)) {
					redisUtil.del(time);
				}*/
				
				result = "ok";
			}
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
	// 加入redis缓存
	@Override
	@Cacheable(value = "findAllById", key = "#id")
	/**
	 * id=用户id
	 */
	public List<Order> findAllById(Integer id) {

		System.out.println("持久层操作");
		List<Order> orders = orderDao.findAllById(id);
		return orders;
	}

	// 更新订单的支付宝号
	@Override
	/**
	 * o_number：订单号 o_paynumber：支付号
	 */
	public String updateOrderByOnum(String o_number, String o_paynumber) {
		Boolean b = orderDao.updateOrderByOnum(o_number, o_paynumber);
		String result = null;
		if (b) {
			result = "ok";
		} else {
			result = "false";
		}
		return result;
	}

	/**
	 * 测试
	 */
	// @CacheEvict(value={"findAllById"},allEntries=true)
	public String test() {

		return "ok";

	}

	/**
	 * 查座次，common类的接口
	 */
	@Override
	public List<Seats> findSeats(Integer scheduleid) {
		List<Seats> seats = new ArrayList<Seats>();
		// 通过scheduleid查找订单
		// 通过订单查seatrecords
		List<Seatrecords> seatsrecords = orderDao.findSeats(scheduleid);
		int roomid = scheduleDao.findRoomid(scheduleid);
		for (int i = 0; i < seatsrecords.size(); i++) {
			Seats seat = new Seats();

			seat.setSe_col(seatsrecords.get(i).getS_seatcol());
			seat.setSe_row(seatsrecords.get(i).getS_seatrow());
			seat.setSe_roomid(roomid);
			seats.add(seat);
		}
		// 将横纵坐标封装返回
		System.out.println(seats);
		return seats;
	}

}
