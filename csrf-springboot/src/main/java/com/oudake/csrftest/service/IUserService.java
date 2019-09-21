package com.oudake.csrftest.service;

import com.oudake.csrftest.model.User;

public interface IUserService {
    User findUserByUsername(String username);

    int addUser(User user);
}
