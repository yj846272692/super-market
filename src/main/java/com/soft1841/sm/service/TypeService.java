package com.soft1841.sm.service;

import com.soft1841.sm.entity.Type;

import java.util.List;

/**
 * 商品类别的业务逻辑接口
 */

public interface TypeService {

        /**
         * 获取所有图书类别的功能
         * @return
         */
        List<Type> getAllTypes();

        /**
         * 根据id查询类别
         * @param id
         * @return
         */
        Type getType(long id);

        /**
         * 添加类别
         * @param type
         */
        Long addType(Type type);

        /**
         * 删除类别
         * @param id
         */
        void deleteType(long id);
}
