package com.soft1841.sm.entity;

import java.util.Date;

/**
 *小票实体类
 * @author 杨晶
 */

public class Receipt {
    private Long id;
    private Long cashierId;
    private Long vipId;
    private Date time;
    private double money;

    public Receipt() {
    }

    public Receipt(Long id, Long cashierId, Long vipId, Date time, double money) {
        this.id = id;
        this.cashierId = cashierId;
        this.vipId = vipId;
        this.time = time;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", cashierId=" + cashierId +
                ", vipId=" + vipId +
                ", time=" + time +
                ", money=" + money +
                '}';
    }
}