package com.huawei.oss.action_manager.config;


import com.alibaba.fastjson.JSON;
import com.huawei.oss.action_manager.pojo.JSONResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JSONResult responseBody = new JSONResult();

        responseBody.setStatus("100");
        responseBody.setMsg("Logout Success!");

        httpServletResponse.setHeader("Content-Type","application/json;charset=UTF-8");

        httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
    }
}
