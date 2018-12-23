package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public List<Entity> selectAdmin() throws Exception {
        return Db.use().query("SELECT * FROM t_admin");
    }

    @Override
    public int deleteAmId(long id) throws Exception {
        return Db.use().del(
                Entity.create("t_admin").set("id",id)
        );
    }

    @Override
    public long insertAdmin(Admin admin) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_admin")
                .set("name",admin.getName())
                .set("admin_number",admin.getAdmin_number())
        );
    }
}
