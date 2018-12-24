package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.ReceiptDAO;
import com.soft1841.sm.entity.Receipt;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 小票的实现类
 */

public class ReceiptDAOImpl implements ReceiptDAO {
    @Override
    public Long insertReceipt(Receipt receipt) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_receipt")
                .set("cashier_id",receipt.getCashierId())
                .set("vip_id",receipt.getVipId())
                .set("time",receipt.getTime())
                .set("money",receipt.getMoney())
        );
    }

    @Override
    public List<Entity> selectAllReceipt() throws SQLException {
        return Db.use().query("SELECT * FROM t_receipt");
    }

    @Override
    public Entity getReceiptId(long id) throws SQLException {
        return (Entity) Db.use().query("SELECT * FROM t_receipt WHERE id = ?",id);
    }

    @Override
    public Entity getCashierId(long cashier_id) throws SQLException {
        return (Entity) Db.use().query("SELECT * FROM t_receipt WHERE cashier_id = ?" , cashier_id);
    }

    @Override
    public Entity getTime(Date time) throws SQLException {
        return (Entity) Db.use().query("SELECT * FROM t_receipt WHERE time = ?" ,time);
    }
}
