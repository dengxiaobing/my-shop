package com.dxb.my.shop.web.admin.web.controller;

import com.dxb.my.shop.commons.dto.BaseResult;
import com.dxb.my.shop.domain.TbUser;
import com.dxb.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 用户管理
 *
 * @author:deng
 * @date: 2019/2/11
 * @time: 8:34 PM
 * @email 657563945@qq.com
 */
@RequestMapping(value = "user")
@Controller
public class UserController {
    @Autowired
    private TbUserService tbUserService;

    @ModelAttribute
    public TbUser getTbUser(Long id) {
        TbUser tbUser = null;
        if (id != null) {
            //id不为空从数据库获取
            tbUser = tbUserService.getById(id);
        } else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 跳转到用户列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }

    /**
     * 跳转到用户表单页面
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    /**
     * 保存用户信息
     *
     * @param tbUser
     * @param
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbUserService.save(tbUser);
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            baseResult.setMessage("保存用户成功");
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }

        //保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }

    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(Model model, TbUser tbUser) {

        List<TbUser> tbUsers = tbUserService.search(tbUser);
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }
}

