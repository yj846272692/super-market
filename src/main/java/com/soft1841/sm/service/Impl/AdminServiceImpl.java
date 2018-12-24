package com.soft1841.sm.service.Impl;

import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Override
    public boolean login(String adminNumber, String password) {
        Admin admin = null;
        try {
            admin = adminDAO.getAdminByNumber(adminNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //根据管理员号码查找成功
        if (admin != null){
            //比较密码
            if (password.equals(admin.getPassword())){
                return true;
            }
        }
        return  false;

    }
}
