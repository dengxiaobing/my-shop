package com.dxb.my.shop.web.admin.dao;


import com.dxb.my.shop.domain.User;

/**
 * @author:deng
 * @date: 2019/1/29
 * @time: 12:26 AM
 * @email 657563945@qq.com
 */
public interface UserDao {
    /**
     * 根据邮箱和密码获取用户信息
     *
     * @param eamil    邮箱
     * @param password 密码
     * @return 用户
     */
    User getUserByEmailAndPassword(String eamil, String password);
}
