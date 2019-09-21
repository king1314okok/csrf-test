package com.oudake.csrftest.controller;

import com.oudake.csrftest.model.ResponseBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyi
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("getMenu")
    public ResponseBean getMenu(Authentication authentication) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseBean(true, "00", "用户" + auth.getName() +"获取菜单成功", authentication.getAuthorities());
    }
}
