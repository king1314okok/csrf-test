package com.oudake.csrftest.auth;

import com.alibaba.fastjson.JSONObject;
import com.oudake.csrftest.model.ResponseBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangyi
 */
@Configuration
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResponseBean responseBean = new ResponseBean(false, "01", "");
        if (e.getClass().equals(InsufficientAuthenticationException.class)) {
            responseBean.setMsg("未授权访问,请登录");
        } else {
            responseBean.setMsg(e.getMessage());
        }
        PrintWriter out = httpServletResponse.getWriter();
        out.write(JSONObject.toJSONString(responseBean));
        out.flush();
        out.close();
    }
}
