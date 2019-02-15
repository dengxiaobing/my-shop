package com.dxb.my.shop.web.admin.service.impl;

import com.dxb.my.shop.domain.User;
import com.dxb.my.shop.web.admin.dao.UserDao;
import com.dxb.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:deng
 * @date: 2019/1/29
 * @time: 12:37 AM
 * @email 657563945@qq.com
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User login(String email, String password) {
        return userDao.getUserByEmailAndPassword(email, password);
    }
}
