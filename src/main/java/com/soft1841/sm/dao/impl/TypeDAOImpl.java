package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;


public class TypeDAOImpl implements TypeDAO {

    @Override
    public Long insert(Type type) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_type")
                        .set("name",type.getType_name()).set("id",type.getId())
                        );
    }

    @Override
    public int delete(int id) throws SQLException {
        return Db.use().del(
                Entity.create("t_type").set("id", id));
    }

    @Override
    public int update(Type type) throws SQLException {
        return  Db.use().update(
                Entity.create().set("price", type.getType_name()),
                Entity.create("t_type").set("id", type.getId()));
    }

    @Override
    public List<Entity> getAllTypes() throws SQLException {
        return Db.use().findAll("t_type");
    }

    @Override
    public Entity get(int id) throws SQLException {
        return Db.use().findAll(Entity.create("t_type").set("id", id)).get(0);
    }
}
