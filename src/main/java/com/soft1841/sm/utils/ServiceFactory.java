package com.soft1841.sm.utils;


import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.Impl.AdminServiceImpl;
import com.soft1841.sm.service.Impl.GoodsServiceImpl;
import com.soft1841.sm.service.Impl.SellerServiceImpl;
import com.soft1841.sm.service.Impl.TypeServiceImpl;
import com.soft1841.sm.service.SellerService;
import com.soft1841.sm.service.TypeService;
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

}
