package com.soft1841.sm.utils;


import com.soft1841.sm.service.*;
import com.soft1841.sm.service.Impl.*;

/**
 * 业务逻辑类工厂
 */

public class ServiceFactory {
    public static TypeService getTypeServiceInstance() { return new TypeServiceImpl(); }
    public static SellerService getSellerServiceInstance() {
        return new SellerServiceImpl();
    }
    public static AdminServiceImpl getAdminServiceInstance(){ return new AdminServiceImpl(); }
    public static GoodsService getGoodsServiceInstance() { return new GoodsServiceImpl(); }
    public static VipService getVipDAOInstance(){return  new VipServiceImpl(); }

    public static SellerGoodsService getSellerGoodsServiceInstance() {return new SellerGoodsServiceImpl();  }
}
