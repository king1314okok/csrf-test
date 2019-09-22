package com.oudake.csrftest.service.impl;

import com.oudake.csrftest.dao.PermissionMapper;
import com.oudake.csrftest.model.Permission;
import com.oudake.csrftest.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangyi
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findPermissionsByUserId(Integer id) {
        return permissionMapper.findPermissionsByUserId(id);
    }

    @Override
    public List<Permission> findPermissionsByRoleId(Integer id) {
        return permissionMapper.findPermissionsByRoleId(id);
    }

    @Override
    public List<Permission> findAllPermissions() {
        return permissionMapper.selectAll();
    }
}
