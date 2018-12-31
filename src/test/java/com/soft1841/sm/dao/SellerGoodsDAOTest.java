package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SellerGoodsDAOTest {
    private SellerGoodsDAO sellerGoodsDAO = DAOFactory.getSellerGoodsDAOInstance();

    @Test
    public void getAllGoods()throws SQLException {
        List<Goods> s = sellerGoodsDAO.getAllGoods();
        s.forEach(goods -> System.out.println(goods));

    }

    @Test
    public void getAllGoods1() {
    }

    @Test
    public void getGoodsByBarCode() throws SQLException {
        Goods goods = sellerGoodsDAO.getGoodsByBarCode("2018001");
        System.out.println(goods.getName());
    }
}