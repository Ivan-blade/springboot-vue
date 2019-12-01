package com.alibaba.mapper;

import com.alibaba.bean.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * mapper的具体表达式
 */
@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface OrderMapper {

    /**
     * 生成订单 插入一条order记录
     * @param order
     * @return
     */
    @Insert("insert into `order` (id,ItemName,CarSize,Origin,Destination) values (#{id},#{ItemName},#{CarSize},#{Origin},#{Destination})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void item(Order order);

    /**
     * 接收订单
     * @param order
     * @return
     */
    @Update("update `order` set DriverName=#{DriverName},OrderStatus=#{OrderStatus} where id=#{id}")
    void driver(Order order);
}
