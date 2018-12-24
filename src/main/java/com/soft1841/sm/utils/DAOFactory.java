package com.soft1841.sm.utils;

import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.dao.impl.AdminDAOImpl;
import com.soft1841.sm.dao.impl.SellerDAOImpl;

public class DAOFactory {
    public static SellerDAO getSellerDAOInstance() {
        return new SellerDAOImpl();
    }

    public static AdminDAO getAdminDAOInstance() {
        return new AdminDAOImpl();
        }
    }

