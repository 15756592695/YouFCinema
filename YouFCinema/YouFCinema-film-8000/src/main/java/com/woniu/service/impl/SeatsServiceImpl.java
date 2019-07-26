package com.woniu.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.dto.ChooseSeatDto;
import com.cinema.pojo.Seats;
import com.cinema.util.RedisUtil;
import com.woniu.dao.SeatsDao;
import com.woniu.rabbit.Sender;
import com.woniu.service.SeatsService;

@Service
public class SeatsServiceImpl implements SeatsService {
	@Autowired
	private SeatsDao seatsDao;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private Sender sender;

	/*
	 * 添加厅室和坐位信息(non-Javadoc)
	 * 
	 * @see com.woniu.service.SeatsService#setSeats(java.lang.String)
	 */
	@Override
	public String setSeats(String seatstr) {
		System.out.println(seatstr);
		String s1 = seatstr.split("\\[\"")[1];
		System.out.println(s1);
		String s2 = s1.split("\"\\]")[0];
		System.out.println(s2);
		String[] seats = s2.split("\",\"");
		System.out.println(Arrays.toString(seats));
		for (int i = 0; i < seats.length; i++) {
			String[] seat = seats[i].split("_");
			int x = Integer.parseInt(seat[0]);
			int y = Integer.parseInt(seat[1]);
			System.out.println("x+y=" + (x + y));
		}
		return null;
	}

	/*
	 * 根据厅室id获取所有坐位(non-Javadoc)
	 * 
	 * @see com.woniu.service.SeatsService#getAllByRid(java.lang.Integer)
	 */
	@Override
	public List<Seats> getAllByRid(Integer roomid) {

		return seatsDao.getAllByRid(roomid);
	}

	@Override
	public List<Seats> getAllSeats() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 用户选中的坐位(non-Javadoc)
	 * 
	 * @see com.woniu.service.SeatsService#getSelectedSeats(java.lang.String)
	 */
	@Override
	public int getSelectedSeats(String seatstr, Integer roomid, Integer scheduleid) {

		String[] s1 = seatstr.split("row\":");
		// 声明一个list存选的坐位
		List<Seats> seats = new ArrayList<>();

		for (int i = 0; i < s1.length; i++) {
			String seat1 = s1[i + 1];
			String[] s2 = seat1.split(",\"col\":");
			int row = Integer.parseInt(s2[0]);
			int col = Integer.parseInt(s2[1].split(",")[0]);
			int seatNum = Integer.parseInt("" + row + col);
			// 查看redis里是否有这个座位信息
			Object se = redisUtil.get("" + scheduleid + roomid + row + col);
			if (se != null) {
				return seatNum;
			}
			Seats seat = new Seats();
			seat.setSe_col(col);
			seat.setSe_row(row);
			seat.setSe_num(seatNum);
			// 添加进集合
			seats.add(seat);
		}
		// 将请求入队
		ChooseSeatDto dto = new ChooseSeatDto();
		dto.setRoomid(roomid);
		dto.setScheduleid(scheduleid);
		sender.send(dto,seats);

		return 1;

	}

}
