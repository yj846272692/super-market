package com.soft1841.sm.service;

import com.soft1841.sm.dao.VipDAO;
import com.soft1841.sm.entity.Vip;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class VipServiceTest {
    private VipDAO vipDAO = DAOFactory.geeVipDAOInstance();

    @Test
    public void getAllVip() {
        List<Vip> vipList = null;
        try {
            vipList = vipDAO.selectVip();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        vipList.forEach(Entity -> System.out.println(Entity));
    }

    @Test
    public void addVip() {
        Vip vip = new Vip();
        vip.setName("ceshi11");
        vip.setMobile("11111111");
        vip.setVipNumber("111");
        vip.setSex("男");
        try {
            vipDAO.insertVip(vip);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteVip() {
    }
}