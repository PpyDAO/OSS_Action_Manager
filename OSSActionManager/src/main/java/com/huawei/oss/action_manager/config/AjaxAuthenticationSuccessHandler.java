package com.huawei.oss.action_manager.config;


import com.alibaba.fastjson.JSON;
import com.huawei.oss.action_manager.pojo.JSONResult;
import com.huawei.oss.action_manager.pojo.User;
import com.huawei.oss.action_manager.utils.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JSONResult responseBody = new JSONResult();

        responseBody.setStatus("200");
        responseBody.setMsg("Login Success!");

        User userDetails = (User) authentication.getPrincipal();

        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), 300, "_secret");
        responseBody.setJwtToken(jwtToken);
        responseBody.setResult(userDetails.getUsername());

        httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
    }
}

