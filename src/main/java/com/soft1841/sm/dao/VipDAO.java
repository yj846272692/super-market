package com.soft1841.sm.dao;
import com.soft1841.sm.entity.Vip;

import java.sql.SQLException;
import java.util.List;

/**
 * VIP DAO
 * @author 杨晶
 * 2018-12-27
 */

public interface VipDAO {
    /**
     * 查询所有Vip信息
     * @return List<Vip>
     * @throws SQLException
     */
    List<Vip> selectVip()throws SQLException;

    /**
     * 根据id删除实体
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(long id) throws SQLException;

    /**
     * 新增一个会员，返回自增主键
     * @param vip
     * @return
     * @throws SQLException
     */
    Long insertVip(Vip vip) throws SQLException;


}
