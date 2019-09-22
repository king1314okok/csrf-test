package com.oudake.csrftest.dao;

import com.oudake.csrftest.model.Permission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<Permission> findPermissionsByUserId(@Param("id") Integer id);

    List<Permission> findPermissionsByRoleId(@Param("id") Integer id);
}