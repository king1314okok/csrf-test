package com.oudake.csrftest.dao;

import com.oudake.csrftest.model.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author wangyi
 */
public interface RoleMapper extends Mapper<Role> {

    List<Role> findRolesByUserId(@Param("id") Integer id);
}