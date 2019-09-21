package com.oudake.csrftest.service;

import com.oudake.csrftest.model.User;

/**
 * @author wangyi
 */
public interface IUserService {
    User findUserByUsername(String username);

    int addUser(User user);
}
