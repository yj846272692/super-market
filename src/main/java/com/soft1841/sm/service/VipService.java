package com.soft1841.sm.service;

import com.soft1841.sm.entity.Vip;

import java.util.List;

/**
 * 会员业务逻辑接口
 * @author 杨晶
 * 2018-12-27
 */

public interface VipService {
    /**
     * 查询所有会员
     */
    List<Vip> getAllVip();

    /**
     * 新增一个会员，返回自增主键
     */
    Long addVip(Vip vip);

    /**
     * 根据ID删除会员
     */
    void  deleteVip(long id);
}
