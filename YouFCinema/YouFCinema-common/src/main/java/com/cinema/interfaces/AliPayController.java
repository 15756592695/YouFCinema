package com.cinema.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="zhifubao")
public interface AliPayController {

	//out_trade_no：订单号
	//subject：商品标题
	//total_amount：价格
    @ResponseBody
    @GetMapping("/pay")
    String pay(@RequestParam("out_trade_no") String out_trade_no ,@RequestParam("subject") String subject,@RequestParam("total_amount") String total_amount);
}
