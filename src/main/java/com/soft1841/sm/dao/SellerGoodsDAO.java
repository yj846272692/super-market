package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.List;

/**商品的接口类
 * @author 赵嘉悦
 * 2018/12/25
 */

 public interface SellerGoodsDAO {
    /**
     * 查询所有商品
     * @return
     * @throws SQLException
     */
        List<Goods> getAllGoods() throws SQLException;


}
