package com.cinema.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="zhifubao")
public interface AliPayController {

    @ResponseBody
    @GetMapping("/pay")
    String pay(String out_trade_no ,String subject,String total_amount, String body, String product_code);
}
