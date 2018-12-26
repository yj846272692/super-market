package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.List;

/**商品的接口类
 * @author jiayue
 * 2018/12/25
 */

 public interface SellerGoodsDAO {

    List<Goods>getAllGoods() throws SQLException;

}
