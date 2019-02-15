package com.dxb.my.shop.web.admin.dao;

import com.dxb.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:deng
 * @date: 2019/1/30
 * @time: 7:54 PM
 * @email 657563945@qq.com
 */
@Repository
public interface TbUserDao {

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
    void insert(TbUser tbUser);

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
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

    /**
     * 搜索
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);
}
