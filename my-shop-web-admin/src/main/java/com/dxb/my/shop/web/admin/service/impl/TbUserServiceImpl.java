package com.dxb.my.shop.web.admin.service.impl;

import com.dxb.my.shop.commons.dto.BaseResult;
import com.dxb.my.shop.commons.utils.RegexpUtils;
import com.dxb.my.shop.domain.TbUser;
import com.dxb.my.shop.web.admin.dao.TbUserDao;
import com.dxb.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author:deng
 * @date: 2019/1/30
 * @time: 7:56 PM
 * @email 657563945@qq.com
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbuser(tbUser);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdated(new Date());

            //新增用户
            if (tbUser.getId() == null) {
                //密码加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));

                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);

                //编辑用户
            } else {
                tbUserDao.update(tbUser);
            }
        }

        return baseResult;
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);

    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> selectByName(String username) {
        return tbUserDao.selectByName(username);
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);

        //明文密码加密
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (tbUser != null) {
            //密码验证
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public List<TbUser> search(TbUser tbUser) {
        return tbUserDao.search(tbUser);
    }


    /**
     * 用户信息的有效验证
     *
     * @param tbUser
     */
    private BaseResult checkTbuser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();
        //非空验证
        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空");
        } else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不正确");
        } else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空");
        } else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("用户名不能为空");
        } else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空");
        } else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机格式不正确");
        }
        return baseResult;
    }
}
