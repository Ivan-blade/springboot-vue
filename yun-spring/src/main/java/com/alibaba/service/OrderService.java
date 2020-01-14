package com.alibaba.service;

import com.alibaba.bean.ResultOrder;
import com.alibaba.bean.Order;
import com.alibaba.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    /**
     * 生成订单
     * @param order 参数封装
     * @return ResultOrder
     */
    public ResultOrder item(Order order) {
        ResultOrder result = new ResultOrder();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            orderMapper.item(order);
            //System.out.println(order.getId());
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
     * 完成订单
     * @param order 参数封装
     * @return ResultOrder
     */
    public ResultOrder driver(Order order) {
        ResultOrder result = new ResultOrder();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            orderMapper.driver(order);
            result.setMsg("订单完成成功");
            result.setSuccess(true);
            result.setDetail(order);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
