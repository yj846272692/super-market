package com.soft1841.sm.service.Impl;

import com.soft1841.sm.dao.SellerGoodsDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.service.SellerGoodsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerGoodsServiceImpl implements SellerGoodsService {

    @Override
    public List<Goods> getAllGooods() {
        List<Goods>goodsList = new ArrayList<>();
        return goodsList;
    }
}

