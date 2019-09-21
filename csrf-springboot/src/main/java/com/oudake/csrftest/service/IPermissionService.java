package com.oudake.csrftest.service;

import com.oudake.csrftest.model.Permission;

import java.util.List;

/**
 * @author wangyi
 */
public interface IPermissionService {
    List<Permission> findPermissionsByUserId(Integer id);
}
