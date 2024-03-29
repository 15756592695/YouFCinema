package com.woniu.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.dto.ChooseSeatDto;
import com.cinema.interfaces.Order02Controller;
import com.cinema.pojo.Schedule;
import com.cinema.pojo.Seats;
import com.cinema.util.RedisUtil;
import com.woniu.dao.ScheduleDao;
import com.woniu.dao.SeatsDao;
import com.woniu.rabbit.DelaySender;
import com.woniu.rabbit.Sender;
import com.woniu.service.SeatsService;

@Service
public class SeatsServiceImpl implements SeatsService {
	@Autowired
	private SeatsDao seatsDao;
	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private Sender sender;
	@Autowired
	private Order02Controller order02Controller;
	
	/*
	 * 根据厅室id获取所有坐位(non-Javadoc)
	 */
	@Override
	public Map<String,Object> getAllByRid(Integer roomid,Integer scheduleid) {
		Map<String,Object> seatMap=new HashMap<>();
		//获取该场电影所有信息
		Schedule movie=scheduleDao.findPriceById(scheduleid);
		//单价
		BigDecimal price=movie.getFilm().getF_price().multiply(new BigDecimal(movie.getS_discount()));
		//电影名
		String filmName=movie.getFilm().getF_name();
		//获取该厅室所有坐位
		List<Seats> seats=seatsDao.getAllByRid(roomid);
		//获取该场电影已经选了的并付款的座位
		List<Seats> selectedSeats=order02Controller.findSeats(scheduleid);
		//获取redis中的座位
		for(int i=0;i<seats.size();i++){
			 Integer row=seats.get(i).getSe_row();
			 Integer col=seats.get(i).getSe_col();
			 String key="s"+ scheduleid  + row + col;
			
			 if(redisUtil.hasKey(key)){
				 Seats seat=new Seats();
				 seat.setSe_col(col);
				 seat.setSe_row(row);
				
				 selectedSeats.add(seat);
			 }
			 
		 }
		seatMap.put("allSeats", seats);
		seatMap.put("selected", selectedSeats);
		seatMap.put("price", price);
		seatMap.put("filmName", filmName);
		return seatMap;
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
			int j=i+1;
			if(j==s1.length){
				break;
			}
			String seat1 = s1[j];
			String[] s2 = seat1.split(",\"col\":");
			
			int row = Integer.parseInt(s2[0]);
			int col = Integer.parseInt(s2[1].split("}")[0]);
			int seatNum = Integer.parseInt("" + row + col);
			String key=	"s"+scheduleid+row+col;	
			
			// 查看map对象里是否有这个座位信息
			/*boolean b=redisUtil.hHasKey("selectedSeats", key);*/
		
			boolean b=redisUtil.hasKey(key);
		
			if (b) {
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
	/*	delaySender.send(dto, seats);*/
		return 1;

	}


}
