package com.soft1841.sm.service;

/**
 * 管理员业务逻辑接口
 * @author 杨晶
 */

public interface AdminService {
    /**
     * 登录功能
     *
     * @param adminNumber
     * @param password
     * @return
     */
    boolean login(String adminNumber, String password);


}
