package com.soft1841.sm.entity;

import java.util.Date;

public class Receipt {
    private  Long id ;
    private  Long cashier_id;
    private  Long vip_id ;
    private Date time ;
    private  double money ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCashier_id() {
        return cashier_id;
    }

    public void setCashier_id(Long cashier_id) {
        this.cashier_id = cashier_id;
    }

    public Long getVip_id() {
        return vip_id;
    }

    public void setVip_id(Long vip_id) {
        this.vip_id = vip_id;
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
                ", cashier_id=" + cashier_id +
                ", vip_id=" + vip_id +
                ", time=" + time +
                ", money=" + money +
                '}';
    }
}
