package com.soft1841.sm.service.Impl;

import com.soft1841.sm.dao.SellerGoodsDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.service.SellerGoodsService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerGoodsServiceImpl implements SellerGoodsService {
    private SellerGoodsDAO sellerGoodsDAO = DAOFactory.getSellerGoodsDAOInstance();


    @Override
    public List<Goods> getAllGooods() {
        List<Goods> goodsList = new ArrayList<>();
        try {
            goodsList = sellerGoodsDAO.getAllGoods();
        } catch (SQLException e) {
           System.err.println("查询所有商品出现异常");
        }
        return goodsList;
    }
}

