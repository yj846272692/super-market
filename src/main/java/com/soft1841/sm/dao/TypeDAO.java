package com.soft1841.sm.dao;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

public interface TypeDAO {
   /**
    * 查询所有类别
    * @return
    */
     List<Entity> selectAllTypes() throws SQLException;
}
