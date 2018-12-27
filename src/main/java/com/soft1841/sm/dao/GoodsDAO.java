package com.soft1841.sm.dao;


import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.List;

/**
 * 商品DAO
 * @author 杨晶
 */

public interface GoodsDAO {
    /**
     * 新增商品，返回自增主键
     *
     * @param goods
     * @return
     * @throws SQLException
     */
    Long insertGoods(Goods goods) throws SQLException;

    /**
     * 根据id删除商品
     *
     * @param id
     * @return
     */
    int deleteGoodsById(long id) throws SQLException;

    /**
     * 更新商品信息
     *
     * @param goods
     * @return
     */
    int updateGoods(Goods goods) throws SQLException;


    /**
     * 查询所有商品
     *
     * @return
     */
    List<Goods> selectAllGoods() throws SQLException;


    /**
     * 根据id查询商品信息
     *
     * @param id
     * @return
     */
    Goods getGoodsById(long id) throws SQLException;

    /**
     * 根据商品名关键词模糊查询商品
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Goods> selectGoodsLike(String keywords) throws SQLException;

    /**
     * 根据商品类别查询商品
     * @param typeId
     * @return
     * @throws SQLException
     */
    List<Goods> selectGoodsByTypeId(long typeId) throws SQLException;

    /**
     * 根据商品类别统计商品数量
     * @param typeId
     * @return
     * @throws SQLException
     */
    int countByType(long typeId) throws SQLException;
}
