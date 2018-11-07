package com.huawei.oss.action_manager.config;

import com.alibaba.fastjson.JSON;
import com.huawei.oss.action_manager.pojo.JSONResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JSONResult responseBody = new JSONResult();

        responseBody.setStatus("400");
        responseBody.setMsg("Login Failure!");

        httpServletResponse.setHeader("Content-Type","application/json;charset=UTF-8");

        httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
    }
}
