package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.DetailDAO;
import com.soft1841.sm.entity.Detail;

import java.sql.SQLException;
import java.util.List;

public class DetailDAOImpl implements DetailDAO {
    @Override
    public Long insertDetail(Detail detail) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_detail")
                        .set("cashier_id",detail.getCashierId())
                        .set("barcode",detail.getBarcode())
                        .set("amount",detail.getAmount())
        );
    }

    @Override
    public List<Entity> selectAllDetail() throws SQLException {
        return Db.use().query("SELECT * FROM t_detail");
    }

    @Override
    public Entity getDetailById(long id) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_detail WHERE id = ? ", id);
    }



    @Override
    public List<Entity> selectDetailsLike(String keywords) throws SQLException {
        return Db.use().findLike("t_detail", "name", keywords, Condition.LikeType.Contains);
    }

    @Override
    public List<Entity> selectDetailsByCashierId(long cashierId) throws SQLException {
        return Db.use().query("SELECT * FROM t_detail WHERE cashier_id = ? ", cashierId);
    }

    @Override
    public List<Entity> selectDetailsByBarcode(String barcode) throws SQLException {
        return Db.use().query("SELECT * FROM t_detail WHERE barcode = ? ", barcode);
    }
}
