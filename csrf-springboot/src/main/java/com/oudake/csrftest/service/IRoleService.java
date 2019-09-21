package com.oudake.csrftest.service;

import com.oudake.csrftest.model.Role;

import java.util.List;

/**
 * @author wangyi
 */
public interface IRoleService {

    List<Role> findRolesByUserId(Integer id);
}
