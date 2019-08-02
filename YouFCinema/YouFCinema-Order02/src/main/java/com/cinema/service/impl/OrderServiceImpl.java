package com.cinema.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
	private RedisUtil redisUtil;

	// 新增
	@Override
	 @CacheEvict(value={"findAllById"},allEntries=true)
	public SeatToOrderDto addOrder(SeatToOrderDto orderDTO) {
		
		// 根据座位数获取票数
		int o_number = orderDTO.getSeats().size();
		// 生成订单号（利用当前毫秒数后八位）
		Date date = new Date();
		String num = date.getTime() + "";
		String ordernumber = num.substring(num.length() - 8, num.length());
		System.out.println("ordernumber:" + ordernumber);
		// 5获取用户id
		Integer uid = 1;
		orderDTO.setO_number(o_number);
		orderDTO.setUid(uid);
		orderDTO.setO_ordernumber(ordernumber);
//		redisUtil.set("ordernumber" + uid, ordernumber);// 订单号存入redis
		// 首先，生成订单
		orderDao.addOrder(orderDTO);
		
		Order neworder = orderDao.findAllByOrder(ordernumber);
		orderDTO.setO_id(neworder.getO_id());
		redisUtil.set("orderDTO"+ ordernumber, orderDTO);//	将该订单的所有信息存入redis
		return orderDTO;
	}

	// 取消订单
	 @CacheEvict(value={"findAllById"},allEntries=true)
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
	public List<SeatToOrderDto> findAllById(Integer id) {

		System.out.println("持久层操作");
		List<SeatToOrderDto> orders = orderDao.findAllById(id);

		return orders;
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

		/**更新订单的支付宝号
		 * o_number：订单号 o_paynumber：支付号
		 */
	@Override
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
	 *新增座次记录
	 */
	@Override
	public void upSeats(SeatToOrderDto orderDTO) {
		
		//生成座次记录表
				for(int i = 0; i < orderDTO.getSeats().size(); i++) {
					seatDao.insertRecords(orderDTO.getRoomName(), orderDTO.getSeats().get(i).getSe_row(), orderDTO.getSeats().get(i).getSe_col(),orderDTO.getO_id());
				}
		
	}

	/**
	 * 查找单条订单信息
	 */
	@Override
	public SeatToOrderDto findOrder(String o_ordernumber) {
		String key="orderDTO"+o_ordernumber;
		SeatToOrderDto oneorder= (SeatToOrderDto) redisUtil.get(key);
		
		System.out.println("oneorder:"+oneorder);
		return oneorder;
	}
}
