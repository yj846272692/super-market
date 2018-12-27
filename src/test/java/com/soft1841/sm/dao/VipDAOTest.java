package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Vip;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class VipDAOTest {
    //从工厂中获取VipDAO实例
    private VipDAO vipDAO = DAOFactory.geeVipDAOInstance();

    @Test
    public void selectVip() {
        List<Vip> vipList = null;
        try {
            vipList = vipDAO.selectVip();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        vipList.forEach(Entity -> System.out.println(Entity));


    }

    @Test
    public void deleteById() {
        try {
            vipDAO.deleteById(10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertVip() {
    }
}