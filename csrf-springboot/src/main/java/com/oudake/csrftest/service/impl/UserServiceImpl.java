package com.oudake.csrftest.service.impl;

import com.oudake.csrftest.dao.UserMapper;
import com.oudake.csrftest.model.CustomUser;
import com.oudake.csrftest.model.User;
import com.oudake.csrftest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyi
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CustomUser findUserByUsername(String username) {
        if ("king".equals(username)) {
            return new CustomUser("1", "king", "111");
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

}
