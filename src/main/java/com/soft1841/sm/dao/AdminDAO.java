package com.soft1841.sm.dao;


import com.soft1841.sm.entity.Admin;


import java.sql.SQLException;

/**
 * 管理员登陆DAO
 * @author 杨晶
 * 2018-12-24
 */

public interface AdminDAO {
    /**
     * 根据工号查询收银员
     * @param adminNumber
     * @return
     * @throws SQLException
     */
    Admin getAdminByNumber(String adminNumber)throws SQLException;

}
