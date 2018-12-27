package com.soft1841.sm.service.Impl;

import com.soft1841.sm.dao.VipDAO;
import com.soft1841.sm.entity.Vip;
import com.soft1841.sm.service.VipService;
import com.soft1841.sm.utils.DAOFactory;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VipServiceImpl implements VipService {
    private  VipDAO vipDAO = DAOFactory.geeVipDAOInstance();

    @Override
    public List<Vip> getAllVip() {
        List<Vip> vipList = new ArrayList<>();
        try {
            vipList = vipDAO.selectVip();
        } catch (SQLException e) {
            System.err.println("查询所有会员出现异常");
        }
        return  vipList;
    }

    @Override
    public Long addVip(Vip vip) {
        long result = 0 ;
        try {
            result = vipDAO.insertVip(vip);
        } catch (SQLException e) {
            System.err.println("增加读者出现异常");
        }
        return  result;

    }

    @Override
    public void deleteVip(long id) {
        try {
            vipDAO.deleteById(id);
        } catch (SQLException e) {
            System.err.println("删除会员信息出现异常");
        }

    }
}
