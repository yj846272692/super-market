package com.soft1841.sm.service;

import com.soft1841.sm.entity.Goods;

import java.util.List;

public interface SellerGoodsService {

    /**
     * 查询所有图书
     * @return
     */
    List<Goods> getAllGooods();

}
