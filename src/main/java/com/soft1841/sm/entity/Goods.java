package com.soft1841.sm.entity;

/**
 * 商品实体类
 * @author 杨晶
 */


public class Goods {
   private  Long id;
   private  long typeId;
   private  String barCode;
   private  String name;
   private  double price;
   private  String picture;
   private  String description;

    public Goods() {
    }

    public Goods(Long id, long typeId, String barCode, String name, double price, String picture, String description) {
        this.id = id;
        this.typeId = typeId;
        this.barCode = barCode;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", barCode='" + barCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
