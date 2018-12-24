package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Detail;

import java.sql.SQLException;
import java.util.List;

public interface DetailDAO {
    /**
     * 新增明细，返回自增主键
     * @param detail
     * @return
     * @throws SQLException
     */
    Long insertDetail(Detail detail) throws SQLException;

    /**
     * 查询所有明细
     * @return
     * @throws SQLException
     */
    List<Entity>selectAllDetail() throws SQLException;


    /**
     * 根据id查询明细
     * @param id
     * @return
     * @throws SQLException
     */
    Entity getDetailById(long id)throws SQLException;

    /**
     * 根据明细关键词模糊查询明细
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Entity>selectDetailsLike(String keywords)throws SQLException;


    /**
     * 根据收银员id查询明细
     * @param cashierId
     * @return
     * @throws SQLException
     */
    List<Entity>selectDetailsByCashierId(long cashierId)throws SQLException;


    /**
     * 根据条码查询明细
     * @param barcode
     * @return
     * @throws SQLException
     */
    List<Entity>selectDetailsByBarcode(String barcode)throws SQLException;



}
