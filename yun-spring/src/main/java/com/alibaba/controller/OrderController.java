package com.alibaba.controller;

import com.alibaba.bean.ResultOrder;
import com.alibaba.bean.Order;
import com.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单生成
     * @param order 参数封装
     * @return ResultOrder
     */
    @PostMapping(value = "/item")
    public ResultOrder item(Order order){
        return orderService.item(order);
    }

    /**
     * 订单处理
     * @param order 参数封装
     * @return ResultOrder
     */
    @PostMapping(value = "/driver")
    public ResultOrder driver(Order order){
        return orderService.driver(order);
    }

    /**
     * 公共订单显示
     */
    @PostMapping(value = "/order_one")
    public List<Order> getOrderOne(){
        return orderService.getOrderOne();
    }

    /**
     * 个体订单显示
     * id用于区分用户，status用于区分订单状态
     */
    @PostMapping(value = "/{userId}/{status}")
    public List<Order> getOrderDeal(Order order){
        return orderService.getOrderDeal(order);
    }
    
}

