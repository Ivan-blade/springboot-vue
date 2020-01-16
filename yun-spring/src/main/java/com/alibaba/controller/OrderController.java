package com.alibaba.controller;

import com.alibaba.bean.Result;
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
    public Result item(Order order){
        return orderService.item(order);
    }

    /**
     * 司机修改订单状态
     * @param order 参数封装
     * @return ResultOrder
     */
    @PostMapping(value = "/driver")
    public Result driver(Order order){
        return orderService.driver(order);
    }

    /**
     * 货主修改订单状态
     * @param order 参数封装
     * @return ResultOrder
     */
    @PostMapping(value = "/itemer")
    public Result itemer(Order order){
        return orderService.itemer(order);
    }

    /**
     * 公共订单显示
     */
    @PostMapping(value = "/order_one")
    public Result getOrderOne(){
        return orderService.getOrderOne();
    }

    /**
     * 个体订单显示
     * id用于区分用户，status用于区分订单状态
     */
    @PostMapping(value = "/{userId}/{status}")
    public Result getOrderDeal(Order order){
        return orderService.getOrderDeal(order);
    }

    /**
     * 货主端所有订单展示
     * id用于区分用户
     */
    @PostMapping(value = "/itemer/{userId}")
    public Result getItemOrderAll(Order order){
        return orderService.getItemOrderAll(order);
    }
    
    /**
     * 司机端所有订单展示
     * id用于区分用户
     */
    @PostMapping(value = "/driver/{userId}")
    public Result getDriverOrderAll(Order order){
        return orderService.getDriverOrderAll(order);
    }
}

