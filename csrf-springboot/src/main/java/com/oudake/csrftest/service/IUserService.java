package com.oudake.csrftest.service;

import com.oudake.csrftest.model.CustomUser;
import com.oudake.csrftest.model.User;

public interface IUserService {
    CustomUser findUserByUsername(String username);

    int addUser(User user);
}
