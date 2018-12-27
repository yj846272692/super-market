package com.soft1841.sm.entity;

/**
 * 小票明细实体类
 * @author 杨晶
 */



public class Detail {
    private  long id;
    private  String  cashierId;
    private  String barCode;
    private long amount;

    public Detail() {
    }

    public Detail(long id, String cashierId, String barCode, long amount) {
        this.id = id;
        this.cashierId = cashierId;
        this.barCode = barCode;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", cashierId='" + cashierId + '\'' +
                ", barCode='" + barCode + '\'' +
                ", amount=" + amount +
                '}';
    }
}
