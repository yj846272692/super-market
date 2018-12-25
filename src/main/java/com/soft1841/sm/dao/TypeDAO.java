package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeDAO {
   /**
    * 查询所有类别
    * @return
    */
     List<Entity> selectAllTypes() throws SQLException;

    /**
     * 新增图书类别, 返回Long
     * @param type
     * @return
     */
    Long insertType(Type type) throws SQLException;

    /**
     * 根据id删除类别
     * @param id
     * @return
     */
    int deleteTypeById(long id) throws SQLException;
}
