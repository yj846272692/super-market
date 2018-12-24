package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceTest {
    private  AdminService adminService = ServiceFactory.getAdminServiceInstance();

    @Test
    public void login() {
        boolean flag = adminService.login("000001","111");
        assertEquals(true,flag);
    }
}