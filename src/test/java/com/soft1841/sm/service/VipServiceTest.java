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
    }

    @Test
    public void deleteVip() {
    }
}