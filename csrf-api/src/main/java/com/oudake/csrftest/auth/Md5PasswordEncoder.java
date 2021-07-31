package com.oudake.csrftest.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class Md5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence password) {
        return DigestUtils.md5DigestAsHex(password.toString().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public boolean matches(CharSequence rawPassword, String inputPassword) {
        return rawPassword.equals(inputPassword);
    }
}
