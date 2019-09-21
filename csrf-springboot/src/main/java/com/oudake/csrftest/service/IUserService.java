package com.oudake.csrftest.service;

import com.oudake.csrftest.model.CustomUser;

public interface IUserService {
    CustomUser findUserByUsername(String username);
}
