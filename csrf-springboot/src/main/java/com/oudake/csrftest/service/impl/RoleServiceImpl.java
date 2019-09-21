package com.oudake.csrftest.service.impl;

import com.oudake.csrftest.dao.RoleMapper;
import com.oudake.csrftest.model.Role;
import com.oudake.csrftest.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangyi
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRolesByUserId(Integer id) {
        return roleMapper.findRolesByUserId(id);
    }
}
