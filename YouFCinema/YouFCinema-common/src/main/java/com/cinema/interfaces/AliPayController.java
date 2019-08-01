package com.cinema.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@FeignClient(name="zhifubao")
public interface AliPayController {

	//out_trade_no：订单号
	//subject：商品标题
	//total_amount：价格
    @ResponseBody
    @GetMapping("/pay")
    public  String pay(@RequestParam("out_trade_no")String out_trade_no ,@RequestParam("subject")String subject,@RequestParam("total_amount")String total_amount) throws Exception;


    @RequestMapping("/refund")
    @ResponseBody
    public void refund(@RequestParam("response") HttpServletResponse response, @RequestParam("ordernumber") String ordernumber, @RequestParam("payNumber") String payNumber, @RequestParam("total_money") String total_money);

}
