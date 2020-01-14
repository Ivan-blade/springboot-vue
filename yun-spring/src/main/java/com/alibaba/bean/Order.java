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
    private Long SenderPhone;
    private Long DriverPhone;
    private String SenderName;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderPhone() {
        return SenderPhone;
    }

    public void setSenderPhone(Long SenderPhone) {
        this.SenderPhone = SenderPhone;
    }

    public Long getDriverPhone() {
        return DriverPhone;
    }

    public void setDriverPhone(Long DriverPhone) {
        this.DriverPhone = DriverPhone;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String SenderName) {
        this.SenderName = SenderName;
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
