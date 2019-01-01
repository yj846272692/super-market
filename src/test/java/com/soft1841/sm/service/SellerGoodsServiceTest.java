package com.soft1841.sm.service;

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SellerGoodsServiceTest {
    private  SellerGoodsService sellerGoodsService = ServiceFactory.getSellerGoodsServiceInstance();

    @Test
    public void getAllGooods() {
        List<Goods> goodsList = sellerGoodsService.getAllGooods();
        goodsList.forEach(goods -> System.out.println(goods));

    }

    @Test
    public void getAllGooods1() {
    }

    @Test
    public void getGoods() {
        Goods goods = sellerGoodsService.getGoodsByBarCode("2018001");
        System.out.println(goods.getName());
    }
}