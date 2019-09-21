package com.oudake.csrftest.controller;

import com.oudake.csrftest.model.ResponseBean;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyi
 */
@RestController
public class LoginController {

    @PostMapping("loginStatus")
    public ResponseBean loginStatus(Authentication authentication) {
        return new ResponseBean(true, "00", "用户:" + authentication.getName() + "已登录");
    }

}
