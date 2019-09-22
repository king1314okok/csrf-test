package com.oudake.csrftest.auth;

import com.alibaba.fastjson.JSONObject;
import com.oudake.csrftest.model.ResponseBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangyi
 */

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setContentType("application/json; charset=utf-8");
        ResponseBean responseBean = new ResponseBean(false, "01", e.getMessage());
        PrintWriter writer = response.getWriter();
        String json = JSONObject.toJSONString(responseBean);
        writer.write(json);
        writer.flush();
    }
}
