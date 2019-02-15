package com.dxb.my.shop.web.admin.service;

import com.dxb.my.shop.commons.dto.BaseResult;
import com.dxb.my.shop.domain.TbUser;
import com.dxb.my.shop.domain.User;

import java.util.List;

/**
 * @author:deng
 * @date: 2019/1/30
 * @time: 7:56 PM
 * @email 657563945@qq.com
 */
public interface TbUserService {
    /**
     * 查询全部用户信息
     *
     * @return
     */
    List<TbUser> selectAll();

    /**
     * 新增
     *
     * @param tbUser
     */
    BaseResult save(TbUser tbUser);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 查询单个用户
     *
     * @param id
     */
    TbUser getById(Long id);

    /**
     * 修改用户
     *
     * @param tbUser
     */
    void update(TbUser tbUser);

    /**
     * 根据用户名模糊匹配
     *
     * @param username
     * @return
     */
    List<TbUser> selectByName(String username);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);

    List<TbUser> search(TbUser tbUser);
}
