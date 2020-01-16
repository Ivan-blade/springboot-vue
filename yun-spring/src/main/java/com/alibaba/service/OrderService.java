package com.alibaba.service;

import com.alibaba.bean.Result;
import com.alibaba.bean.Order;
import com.alibaba.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    /**
     * 生成订单
     * @param order 参数封装
     * @return Result
     */
    public Result item(Order order) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            orderMapper.item(order);
            result.setMsg("订单生成成功");
            result.setSuccess(true);
            result.setDetail(order);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 司机修改订单状态
     * @param order 参数封装
     * @return Result
     */
    public Result driver(Order order) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            orderMapper.driver(order);
            result.setMsg("司机端订单修改成功");
            result.setSuccess(true);
            result.setDetail(order);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 货主修改订单状态
     * @param order 参数封装
     * @return Result
     */
    public Result itemer(Order order) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            orderMapper.itemer(order);
            result.setMsg("货主端订单修改成功");
            result.setSuccess(true);
            result.setDetail(order);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 显示公共订单
     */
    public Result getOrderOne() {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            List<Order> order= orderMapper.getOrderOne();
            result.setMsg("状态为一的订单获取成功");
            result.setSuccess(true);
            result.setDetail(order);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 显示个体订单
     */
    public Result getOrderDeal(Order order) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            List<Order> orderdeal = orderMapper.getOrderDeal(order);
            result.setMsg("订单获取成功");
            result.setSuccess(true);
            result.setDetail(orderdeal);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result getItemOrderAll (Order order) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            List<Order> orderdeal = orderMapper.getItemOrderAll(order);
            result.setMsg("货主端所有订单信息获取完毕");
            result.setSuccess(true);
            result.setDetail(orderdeal);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result getDriverOrderAll (Order order) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            List<Order> orderdeal = orderMapper.getDriverOrderAll(order);
            result.setMsg("司机端所有订单信息获取完毕");
            result.setSuccess(true);
            result.setDetail(orderdeal);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
