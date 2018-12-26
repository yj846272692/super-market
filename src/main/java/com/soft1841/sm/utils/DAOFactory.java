package com.soft1841.sm.utils;
/**
 * 工厂类，用静态方法来生成各个DAO实例
 */

import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.dao.impl.AdminDAOImpl;
import com.soft1841.sm.dao.impl.GoodsDAOImpl;
import com.soft1841.sm.dao.impl.SellerDAOImpl;
import com.soft1841.sm.dao.impl.TypeDAOImpl;

public class DAOFactory {
    public static SellerDAO getSellerDAOInstance() {
        return new SellerDAOImpl();
    }

    public static AdminDAO getAdminDAOInstance() {
        return new AdminDAOImpl();
    }

    public static TypeDAO getTypeDAOInstance() { return new TypeDAOImpl();
    }

    public static GoodsDAO getGoodsDAOInstance() {
        return new GoodsDAOImpl();
    }
}

