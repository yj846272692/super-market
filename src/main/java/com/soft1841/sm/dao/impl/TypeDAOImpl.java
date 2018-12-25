package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;

import java.sql.SQLException;
import java.util.List;

public class TypeDAOImpl implements TypeDAO {
    @Override
    public List<Entity> selectAllTypes() throws SQLException {
        return Db.use().query("SELECT * FROM t_type");
    }
}
