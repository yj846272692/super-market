package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;



public class SellerServiceTest {
    private  SellerService sellerService = ServiceFactory.getSellerServiceInstance();

    @Test
    public void login() {
        boolean flag = sellerService.login("666001","001");
        System.out.println(flag);

    }
}