package com.minsx.framework.security.aop;

import com.minsx.framework.common.http.ResponseUtil;
import com.minsx.framework.security.configurer.WebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogoutHandler implements HandlerInterceptor {

    @Autowired
    WebSecurity webSecurity;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String logoutUrl = webSecurity.logoutConfigurer().getLogoutUrl();
        if (httpServletRequest.getRequestURI().equalsIgnoreCase(logoutUrl)) {
            System.out.println("已退出登录");
        }
        ResponseUtil.responseJson(httpServletResponse, 200, "logout success");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
