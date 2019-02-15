package com.dxb.my.shop.web.admin.web.controller;

import com.dxb.my.shop.commons.constant.ConstantUtils;
import com.dxb.my.shop.domain.TbUser;
import com.dxb.my.shop.web.admin.service.TbUserService;
import com.dxb.my.shop.web.admin.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录控制器
 *
 * @author:deng
 * @date: 2019/1/29
 * @time: 12:53 AM
 * @email 657563945@qq.com
 */
@Controller
public class LoginController {
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest) {

        String userInfo = CookieUtils.getCookieValue(httpServletRequest, ConstantUtils.COOKIE_NAME_USER_INFO);

        if (StringUtils.isNotBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            httpServletRequest.setAttribute("email", email);
            httpServletRequest.setAttribute("password", password);
            httpServletRequest.setAttribute("isRemember", true);
        }
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, @RequestParam(required = false) String isRemember, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        TbUser tbUser = tbUserService.login(email, password);
        if (tbUser != null) {
            if (isRemember != null ? true : false) {
                CookieUtils.setCookie(httpServletRequest, httpServletResponse, ConstantUtils.COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            } else {
                CookieUtils.deleteCookie(httpServletRequest, httpServletResponse, ConstantUtils.COOKIE_NAME_USER_INFO);
            }

            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);

            return "redirect:/main";

        } else {
            model.addAttribute("message", "用户名或密码不正确");
            return "login";
        }

    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return login(httpServletRequest);
    }
}



