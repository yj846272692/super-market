package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SellerGoodsDAO;
import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerGoodsDAOImpl implements SellerGoodsDAO {
    @Override
    public List<Goods> getAllGoods() throws SQLException {
            List<Entity> entityList = Db.use().query("SELECT * FROM t_goods ");
            List<Goods> goodsList = new ArrayList<>();
            for (Entity entity : entityList) {
                goodsList.add(convertGoods(entity));
            }
            return goodsList;
        }
    private Goods convertGoods(Entity entity) {
        Goods goods = new Goods();
        goods.setId(entity.getLong("id"));
        goods.setTypeId(entity.getLong("type_id"));
        goods.setBarCode(entity.getStr("barcode"));
        goods.setName(entity.getStr("name"));
        goods.setPrice(entity.getDouble("price"));
        goods.setPicture(entity.getStr("picture"));
        goods.setDescription(entity.getStr("description"));
        return goods;
    }
}
