package com.cinema.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.SeatToOrderDto;
import com.cinema.pojo.Order;
import com.cinema.pojo.Seats;
import com.cinema.service.OrderService;
import com.cinema.util.RedisUtil;

import io.swagger.annotations.ApiOperation;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 前端提交的数据，放入redis缓存
	 */
	@PostMapping("/postMessage")
	@ApiOperation(value="发送数据",notes="将信息保存在redis")
	public String view(@RequestBody SeatToOrderDto orderDTO) {
		String uid="1";
		redisUtil.set("order"+uid, orderDTO, 900l);
		return "ok";
	}
	
	/**
	 * 在redis中获取信息，渲染前端
	 */
	@GetMapping("/getMassage")
	public SeatToOrderDto getMessage() {
		String uid="1";
		SeatToOrderDto seatToOrderDto= (SeatToOrderDto) redisUtil.get("order"+uid);
		return seatToOrderDto;
	}
	
	
	
	/**
	 * 查座次，common类的接口
	 */
	@GetMapping("/getSeats/{scheduleid}")
	@ApiOperation(value="获取座位",notes="获取座位")
	public List<Seats> findSeats(@PathVariable("scheduleid")Integer scheduleid) {
		//通过scheduleid查找订单
		//通过订单查seatrecords
		//将横纵坐标封装返回
		List<Seats> seat=null;
		seat=orderService.findSeats(scheduleid);
		return seat;
	}
	
	@GetMapping("/test")
	@ApiOperation(value="测试",notes="测试")
	/**
	 * 
	 * @param order
	 * @return
	 */
	public boolean  test() {
		
		boolean b =redisUtil.set("key", "value");
		return b;
	}
	
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	@PostMapping("/addOrder")
	@ApiOperation(value="增",notes="新增订单")
	public String addOrder(@RequestBody SeatToOrderDto orderDTO) {
		System.out.println(orderDTO);
		String result=orderService.addOrder(orderDTO);
		return result;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/findAllById/{id}")
	@ApiOperation(value="查",notes="查看用户所有订单")
	public List<SeatToOrderDto> findAllById(@PathVariable("id")Integer id){
		List<SeatToOrderDto> orders=orderService.findAllById(id);
		System.out.println(orders);
		return orders;
	}

	
	@PutMapping("/updateOrder/{o_number}/{o_paynumber}")
	@ApiOperation(value="改",notes="将交易号插入订单")
	public String updateOrderByOnum(@PathVariable("o_number")String o_number,@PathVariable("o_paynumber")String o_paynumber) {
		
		String result=orderService.updateOrderByOnum(o_number,o_paynumber);
		System.out.println(result);
		return result;
		
	}
	
	
	/**
	 * 删除用户的缓存，用于取消未支付的订单
	 * @return
	 */
	public String del() {
		String key="findAllById::"+1;//1代表用户id，后期替换
		if(redisUtil.hasKey(key)) {
			redisUtil.del(key);
		}
		return "ok";
	}
	
	
	
	/**
	 * 退款调用此方法，将订单的flag改为2
	 * @param o_id
	 * @return
	 */
	@PutMapping("/updateById/{o_id}")
	@ApiOperation(value="取消",notes="取消订单")
	public String cancel(@PathVariable Integer o_id) {
		String result=orderService.cancel(o_id);
		return result;
	}
	
	
	
	
	/**
	 * 用于计算未支付订单剩余时间，获取的是创建时间+总剩余时间
	 * @return
	 */
	@GetMapping("/gettime")
	public String getDate(){
		String begintime=redisUtil.get("dateTime::"+1)+"";
		return begintime;
	}
	
}
