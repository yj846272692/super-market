package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.List;

/**前台商品的接口类
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


    /**
     * 根据条形码查询商品信息
     * @param barcode
     * @return
     * @throws SQLException
     */
    Goods getGoodsByBarCode(String barcode) throws SQLException;
}
