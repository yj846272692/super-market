package com.soft1841.sm.service;

import com.soft1841.sm.entity.Goods;

import java.util.List;

/**
 * 商品业务逻辑接口
 * @author 杨晶
 */

public interface GoodsService  {
    /**
     * 新增商品，返回自增主键
     * @param goods
     * @return
     */
    Long addGoods(Goods goods);

    /**
     * 根据id删除商品
     * @param id
     * @return
     */
    void deleteGoods(long id);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    void updateGoods(Goods goods);

    /**
     * 查询所有商品
     * @return List<Goods>
     */
    List<Goods> getAllGoods();

    /**
     * 根据id查询商品信息
     *
     * @param id
     * @return Goods
     */
    Goods getGoods(long id);

    /**
     * 根据商品名字关键词模糊查询商品
     *
     * @param keywords
     * @return List<Goods>
     */
    List<Goods> getGoodsLike(String keywords);

    /**
     * 根据商品类别查询商品
     *
     * @param typeId
     * @return List<Goods>
     */
    List<Goods> getGoodsByTypeId(long typeId);

    /**
     * 根据商品类别统计商品数量
     *
     * @param typeId
     * @return
     */
    int countByType(long typeId);

}
