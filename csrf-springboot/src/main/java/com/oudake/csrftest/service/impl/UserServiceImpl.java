package com.oudake.csrftest.service.impl;

import com.oudake.csrftest.dao.UserMapper;
import com.oudake.csrftest.model.User;
import com.oudake.csrftest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author wangyi
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

}
