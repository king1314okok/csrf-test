package com.oudake.csrftest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author wangyi
 */
@Component
public class LoginAuthProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (username == null || "".equals(username)) {
            throw new BadCredentialsException("请输入用户名");
        }
        if (password == null || "".equals(password)) {
            throw new BadCredentialsException("请输入密码");
        }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        boolean isValid = passwordEncoder.matches((String) authentication.getCredentials(), userDetails.getPassword());
        if (!isValid) {
            throw new BadCredentialsException("登录密码错误");
        }
        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
