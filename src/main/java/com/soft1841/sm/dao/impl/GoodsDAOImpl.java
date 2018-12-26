package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO {


    @Override
    public Long insertGoods(Goods goods) throws SQLException {
        return  Db.use().insertForGeneratedKey(
                Entity.create("t_goods")
                        .set("type_id", goods.getTypeId())
                        .set("barcode", goods.getBarCode())
                        .set("name", goods.getName())
                        .set("price", goods.getPrice())
                        .set("picture", goods.getPicture())
                        .set("description", goods.getDescription()));
    }

    @Override
    public int deleteGoodsById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_goods").set("id", id)
        );
    }

    @Override
    public int updateGoods(Goods goods) throws SQLException {
        //只修改了图书的价格和库存
        return Db.use().update(
                Entity.create().set("price", goods.getPrice()),
                Entity.create("t_goods").set("id", goods.getId())
        );
    }

    @Override
    public List<Goods> selectAllGoods() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods ");
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    @Override
    public Goods getGoodsById(long id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_goods WHERE id = ? ", id);
        return convertGoods(entity);
    }

    @Override
    public List<Goods> selectGoodsLike(String keywords) throws SQLException {
        List<Entity> entityList = Db.use().findLike("t_goods", "name", keywords, Condition.LikeType.Contains);
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    @Override
    public List<Goods> selectGoodsByTypeId(long typeId) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods WHERE type_id = ? ", typeId);
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    @Override
    public int countByType(long typeId) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_goods WHERE type_id = ? ", typeId).intValue();
    }

    private  Goods convertGoods(Entity entity){
        Goods goods = new Goods();
        goods.setId(entity.getLong("id"));
        goods.setTypeId(entity.getLong("type_id"));
        goods.setBarCode(entity.getStr("barcode"));
        goods.setName(entity.getStr("name"));
        goods.setPrice(entity.getDouble("price"));
        goods.setPicture(entity.getStr("picture"));
        goods.setDescription(entity.getStr("description"));
        return  goods;
    }
}
