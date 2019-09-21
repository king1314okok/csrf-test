package com.oudake.csrftest.service.impl;

import com.oudake.csrftest.model.CustomUser;
import com.oudake.csrftest.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public CustomUser findUserByUsername(String username) {
        if ("king".equals(username)) {
            return new CustomUser("1", "king", "111");
        }
        return null;
    }
}
