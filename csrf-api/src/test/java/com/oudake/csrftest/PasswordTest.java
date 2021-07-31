package com.oudake.csrftest;

import com.oudake.csrftest.auth.Md5PasswordEncoder;
import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordTest {

    @Test
    public void encode() {
        PasswordEncoder encoder = new Md5PasswordEncoder();
        String result = encoder.encode("pass1234");
        // b4af804009cb036a4ccdc33431ef9ac9
        System.out.println(result);
    }
}
