package com.huawei.oss.action_manager.config;

import com.alibaba.fastjson.JSON;
import com.huawei.oss.action_manager.pojo.JSONResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JSONResult responseBody = new JSONResult();

        responseBody.setStatus("000");
        responseBody.setMsg("Need Authorities!");

        httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
    }
}
