package com.cinema.controller;

import com.cinema.interfaces.OrderController;
import com.cinema.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserOrderController {

    @Autowired
    private OrderController orderController;

    @GetMapping("user/findAllByUid/{uid}")
    public List<Order> findAllByUid(@PathVariable("uid")Integer uid) {
        return orderController.findAllByUid(uid);

    }
}
