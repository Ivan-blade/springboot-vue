package com.alibaba.mapper;

import com.alibaba.bean.Order;
import com.alibaba.bean.ResultOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * mapper的具体表达式
 */
@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface OrderMapper {

    /**
     * 接收订单
     * @param order
     * @return
     */
    @Update("update `order` set DriverName=#{DriverName},DriverPhone=#{DriverPhone},OrderStatus=#{OrderStatus} where id=#{id}")
    void driver(Order order);

    /**
     * 生成订单 插入一条order记录
     * @param order
     * @return
     */
    @Insert("insert into `order` (ItemName,CarSize,Origin,Destination,SenderName,SenderPhone) values (#{ItemName},#{CarSize},#{Origin},#{Destination},#{SenderName},#{SenderPhone})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void item(Order order);

    /**
     * 显示订单
     */
    @Select("select * from `order` where OrderStatus=1")
    List<Order> getOrderOne();
    
}
