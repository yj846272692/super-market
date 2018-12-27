package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.VipDAO;
import com.soft1841.sm.entity.Vip;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Vip DAO的实现类
 * @author 杨晶
 * 2018-12-27
 */

public class VipDAOImpl implements VipDAO {

    @Override
    public List<Vip> selectVip() throws SQLException {
            List<Entity> entityList =  Db.use().query("SELECT * FROM t_vip ");
            List<Vip> vipList = new ArrayList<>();
            for (Entity entity: entityList) {
                vipList.add(convertVip(entity));
            }
            return vipList;
    }

    @Override
    public int deleteById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_vip").set("id", id)
        );
    }

    @Override
    public Long insertVip(Vip vip) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_vip")
                .set("name",vip.getName())
                .set("sex" , vip.getSex())
                .set("mobile",vip.getMobile())
                .set("vipNumber",vip.getVipNumber())
                .set("joinDate" ,vip.getJoinDate())
        );
    }

    /**
     * 将Entity转换为Vip
     *
     * @param entity
     * @return Vip
     */

    private Vip convertVip(Entity entity) {
        Vip vip = new Vip();
        vip.setId(entity.getLong("id"));
        vip.setName(entity.getStr("name"));
        vip.setSex(entity.getStr("sex"));
        vip.setMobile(entity.getStr("mobile"));
        vip.setVipNumber(entity.getStr("vip_number"));
        vip.setJoinDate(entity.getDate("join_date"));
        return vip;

    }
}
