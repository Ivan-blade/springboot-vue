package com.alibaba.bean;

/**
 * 用户信息
 */
public class Order {
    private Long id;
    private String itemName;
    private String driverName;
    private String carSize;
    private int orderStatus;
    private String origin;
    private String destination;
    private Long senderPhone;
    private Long driverPhone;
    private String senderName;

    public Order() {

    }

    public Order(Long id, String itemName, String driverName, String carSize, int orderStatus, String origin, String destination, Long senderPhone, Long driverPhone, String senderName){
        this.id = id;
        this.itemName = itemName;
        this.driverName = driverName;
        this.carSize = carSize;
        this.orderStatus = orderStatus;
        this.origin = origin;
        this.destination = destination;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.driverPhone = driverPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(Long senderPhone) {
        this.senderPhone = senderPhone;
    }

    public Long getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(Long driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getsenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getCarSize() {
        return carSize;
    }

    public void setCarSize(String carSize) {
        this.carSize = carSize;
    }
    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
