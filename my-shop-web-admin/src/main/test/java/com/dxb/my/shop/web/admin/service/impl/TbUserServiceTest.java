package com.dxb.my.shop.web.admin.service.impl;

import com.dxb.my.shop.domain.TbUser;
import com.dxb.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author:deng
 * @date: 2019/1/30
 * @time: 8:16 PM
 * @email 657563945@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }


    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setEmail("admin@dxb.com");
        tbUser.setPassword("admin");
        tbUser.setPhone("15888888888");
        tbUser.setUsername("dxb");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserService.save(tbUser);

    }

    @Test
    public void testDelete() {

        tbUserService.delete(39L);
    }

    @Test
    public void testGetById() {
        TbUser tbUser = tbUserService.getById(36L);
        System.out.println(tbUser);
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("dxb4");

        tbUserService.update(tbUser);
    }

    @Test
    public void testSelectByName() {
        List<TbUser> tbUsers = tbUserService.selectByName("xb");
        for (TbUser tbUser :
                tbUsers) {
            System.err.println(tbUser.getId());
        }
    }

    @Test
    public void testMD5() {
        String md5DigestAsHex = DigestUtils.md5DigestAsHex("admin".getBytes());
        System.err.println(md5DigestAsHex);
    }


}
