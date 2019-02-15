package com.dxb.my.shop.web.admin.service;


import com.dxb.my.shop.domain.User;

/**
 * @author:deng
 * @date: 2019/1/29
 * @time: 12:36 AM
 * @email 657563945@qq.com
 */
public interface UserService {
    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @return
     */
     User login(String email, String password);
}
