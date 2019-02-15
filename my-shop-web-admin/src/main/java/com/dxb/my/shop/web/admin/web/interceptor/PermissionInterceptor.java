package com.dxb.my.shop.web.admin.web.interceptor;

import com.dxb.my.shop.commons.constant.ConstantUtils;
import com.dxb.my.shop.domain.TbUser;
import com.dxb.my.shop.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author:deng
 * @date: 2019/1/30
 * @time: 11:51 AM
 * @email 657563945@qq.com
 */
public class PermissionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 如果请求来自登录页
        String viewName = modelAndView.getViewName();
        if (viewName != null && viewName.endsWith("login")) {
            TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            // 则直接重定向到首页不再显示登录页
            if (tbUser != null) {
                httpServletResponse.sendRedirect("/main");
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
