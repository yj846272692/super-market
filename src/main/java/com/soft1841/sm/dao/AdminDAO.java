package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
        import com.soft1841.sm.entity.Admin;

        import java.sql.SQLException;
        import java.util.List;

public interface AdminDAO {
    List<Entity> selectAdmin() throws  Exception;
    int deleteAmId(long id) throws Exception;
    long insertAdmin(Admin admin ) throws SQLException;
}
