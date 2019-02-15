package com.dxb.my.shop.web.admin.dao.impl;

import com.dxb.my.shop.domain.User;
import com.dxb.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * @author:deng
 * @date: 2019/1/29
 * @time: 12:31 AM
 * @email 657563945@qq.com
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User getUserByEmailAndPassword(String eamil, String password) {
        logger.debug("调用getUser()方法，email:{},password:{}", eamil, password);
        User user = null;
        if ("admin@dxb.com".equals(eamil)) {
            if ("admin".equals(password)) {
                user = new User();
                user.setEmail("admin@dxb.com");
                user.setUsername("dxb");
                logger.info("成功获取\"{}\"的信息", user.getUsername());
            }
        } else {
            logger.info("获取\"{}\"的信息失败", eamil);
        }
        return user;
    }
}
