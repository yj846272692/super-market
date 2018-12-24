package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.entity.Admin;

import java.sql.SQLException;


public class AdminDAOImpl implements AdminDAO {

    @Override
    public Admin getAdminByNumber(String adminNumber) throws SQLException {
        Entity entity =  Db.use().queryOne("SELECT * FROM t_admin WHERE adminnumber = ? ",adminNumber );
        return convertAdmin(entity);
    }

    private Admin convertAdmin(Entity entity) {
        Admin admin =  new Admin(entity.getLong("id"),entity.getStr("name"),
                entity.getStr("adminnumber"),entity.getStr("password"));
       return admin;

    }
}
