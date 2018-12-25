package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

public class TypeDAOImpl implements TypeDAO {
    @Override
    public List<Entity> selectAllTypes() throws SQLException {
        return Db.use().query("SELECT * FROM t_type");
    }

    @Override
    public Long insertType(Type type) throws SQLException {
        return  Db.use().insertForGeneratedKey(
                Entity.create("t_type")
                .set("type_name",type.getTypeName())
        );
    }

    @Override
    public int deleteTypeById(long id) throws SQLException {
        return  Db.use().del(
                Entity.create("t_type").set("id",id)
        );
    }
}
