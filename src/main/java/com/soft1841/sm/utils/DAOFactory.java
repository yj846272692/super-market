package com.soft1841.sm.utils;

import com.soft1841.sm.dao.AdminDAO;
import com.soft1841.sm.dao.SellerDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.dao.impl.AdminDAOImpl;
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
}

