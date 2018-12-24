package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;


import java.sql.SQLException;
import java.util.List;

public interface TypeDAO {
    Long insert(Type type) throws SQLException;

    int delete(int id) throws SQLException;

    int update(Type type) throws SQLException;

    List<Entity> getAllTypes() throws SQLException;

    Entity get(int id) throws SQLException;

}
