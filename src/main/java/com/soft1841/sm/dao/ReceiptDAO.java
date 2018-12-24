package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Receipt;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ReceiptDAO {
    //增加小票
    Long insertReceipt(Receipt receipt) throws SQLException;
    //查询所有小票
    List<Entity> selectAllReceipt() throws  SQLException;
    //根据ID查询小票
    Entity getReceiptId(long id) throws  SQLException;
    //根据收银员ID查询小票
    Entity getCashierId(long cashier_id) throws  SQLException;
    //根据时间查询小票
    Entity getTime(Date time) throws SQLException;
}
