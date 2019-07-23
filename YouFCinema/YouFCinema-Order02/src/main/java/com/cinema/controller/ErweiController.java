package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.service.ErweiService;
import com.cinema.util.QRCodeUtil;

@RestController
public class ErweiController {
	
	@Autowired
	private ErweiService erweiService;
	
	//用户订单号作为电影取票码
	@GetMapping("/erweiPic/{o_id}")
	public String createPic(@PathVariable("o_id")Integer o_id) {
		String s=erweiService.createPic(o_id);
		if(s!=null) {
			return "ok";
		}

		return null;
	}

}
