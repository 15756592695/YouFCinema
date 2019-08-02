package com.cinema.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.SeatToOrderDto;
import com.cinema.interfaces.AliPayController;
import com.cinema.pojo.Order;
import com.cinema.pojo.Seats;
import com.cinema.service.OrderService;
import com.cinema.util.RedisUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private AliPayController aliPayController;
	
	/**
	 * 前端提交的数据，放入redis缓存
	 */
	@PostMapping("/postMessage")
	@ApiOperation(value="发送数据",notes="将信息保存在redis")
	public String view(@RequestBody SeatToOrderDto orderDTO) {
		String uid="1";
		System.out.println(orderDTO);
//		redisUtil.set("order"+uid, orderDTO, 900l);
		redisUtil.set("order"+uid, orderDTO);
		return "ok";
	}
	
	/**
	 * 在redis中获取信息，渲染前端
	 */
	@GetMapping("/getMassage")
	public SeatToOrderDto getMessage() {
		System.out.println("请求");
		String uid="1";
		SeatToOrderDto seatToOrderDto= (SeatToOrderDto) redisUtil.get("order"+uid);
		System.out.println(seatToOrderDto);
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
	
	@PostMapping("/test")
	@ApiOperation(value="测试",notes="测试")
	/**
	 * 
	 * @param order
	 * @return
	 */
	public SeatToOrderDto test(@RequestBody SeatToOrderDto orderDTO) {
		System.out.println(orderDTO.getDate());
		return orderDTO;
	}
	
	
	/**
	 * 
	 * @param order
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/addOrder")
	@ApiOperation(value="增",notes="新增订单")
	public String addOrder() throws Exception {
		String uid="1";
//		redisUtil.set("order"+uid, orderDTO, 900l);
		SeatToOrderDto orderDTO01=(SeatToOrderDto) redisUtil.get("order"+uid);//获取前端提交在redis的订单数据，只有15分钟有效
		SeatToOrderDto orderDTO=orderService.addOrder(orderDTO01);
		System.out.println("orderDTO:"+orderDTO);
		return aliPayController.pay(orderDTO.getO_ordernumber(), orderDTO.getFilmName(), orderDTO.getPrice() + "");
	}

	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/findAllById")
	@ApiOperation(value="查",notes="查看用户所有订单")
	public List<SeatToOrderDto> findAllById(@RequestParam("id")Integer id){
		List<SeatToOrderDto> orders=orderService.findAllById(id);
		System.out.println(orders);
		return orders;
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
	 * 订单过时调用此方法，将订单的flag改为2
	 * @param o_id
	 * @return
	 */
	@PutMapping("/updateById/{o_id}")
	@ApiOperation(value="取消",notes="取消订单")
	public String cancel(@PathVariable Integer o_id) {
		String result=orderService.cancel(o_id);
		return result;
	}
	
	
	@GetMapping("/testpay")
	public String payTest() throws Exception {
		
	System.out.println("11");
		
		
		 return aliPayController.pay("111", "dd", "1");
	}
	
	/**
	 * 支付宝接口调用的方法1
	 * @param orderDTO
	 */
	@PostMapping("/upSeats")
	public void upSeats(@RequestBody SeatToOrderDto orderDTO) {
		orderService.upSeats(orderDTO);
	}
	/**
	 * 支付宝接口调用的方法2
	 * @param o_number
	 * @param o_paynumber
	 * @return
	 */
	@PutMapping("/updateOrder/{o_number}/{o_paynumber}")
	@ApiOperation(value="改",notes="将交易号插入订单")
	public String updateOrderByOnum(@PathVariable("o_number")String o_number,@PathVariable("o_paynumber")String o_paynumber) {
		
		String result=orderService.updateOrderByOnum(o_number,o_paynumber);
		System.out.println(result);
		return result;
		
	}
	
	
	/**
	 * 根据订单信息查询该订单的信息
	 */
	@GetMapping("/findOrder")
	@ApiOperation(value="查",notes="查单条订单")
	public SeatToOrderDto findOrderByOIdUid (@RequestParam("o_ordernumber")String o_ordernumber) {
		SeatToOrderDto order=orderService.findOrder(o_ordernumber);
		return order;
	}
	

	
}
