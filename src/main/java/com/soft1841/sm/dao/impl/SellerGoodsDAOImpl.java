package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SellerGoodsDAO;
import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;

public class SellerGoodsDAOImpl implements SellerGoodsDAO {
    @Override
    public Goods getAllGoods() throws SQLException {
        Entity entity =  Db.use().queryOne("SELECT * FROM t_goods");
        return convertGoods(entity);
    }
    private Goods convertGoods(Entity entity){
        Goods goods = new Goods(entity.getLong("id"),
                entity.getLong("typeId"),
                entity.getStr("barcode"),
                entity.getStr("name"),
                entity.getDouble("price"),
                entity.getStr("picture"),
                entity.getStr("description"));
        return  goods;
    }
}
