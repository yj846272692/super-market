package com.soft1841.sm.utils;

import com.soft1841.sm.service.Impl.AdminServiceImpl;
import com.soft1841.sm.service.Impl.SellerGoodsServiceImpl;
import com.soft1841.sm.service.Impl.SellerServiceImpl;
import com.soft1841.sm.service.SellerGoodsService;
import com.soft1841.sm.service.SellerService;

public class ServiceFactory {
    public static SellerService getSellerServiceInstance() {
        return new SellerServiceImpl();
    }
    public static AdminServiceImpl getAdminServiceInstance(){
        return new AdminServiceImpl();
    }
    public static SellerGoodsService getSellerGoodsServiceInstance() { return new SellerGoodsServiceImpl(); }

}
