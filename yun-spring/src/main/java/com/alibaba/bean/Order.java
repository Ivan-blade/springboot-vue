package com.alibaba.bean;

/**
 * 用户信息
 */
public class Order {
    private Long id;
    private String ItemName;
    private String DriverName;
    private String CarSize;
    private int OrderStatus;
    private String Origin;
    private String Destination;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String DriverName) {
        this.DriverName = DriverName;
    }
    public String getCarSize() {
        return CarSize;
    }

    public void setCarSize(String CarSize) {
        this.CarSize = CarSize;
    }
    public int getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(int OrderStatus) {
        this.OrderStatus = OrderStatus;
    }
    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }
    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }
}
