package com.soft1841.sm.utils;

import com.soft1841.sm.service.Impl.SellerServiceImpl;
import com.soft1841.sm.service.SellerService;

public class ServiceFactory {
    public static SellerService getSellerServiceInstance() {
        return new SellerServiceImpl();
    }
}
