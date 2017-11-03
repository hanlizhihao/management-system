package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    long getRoleRowCount(Assist assist);
    List<Role> selectRole(Assist assist);
    Role selectRoleById(Integer id);
    int insertRole(Role value);
    int insertNonEmptyRole(Role value);
    int deleteRoleById(Integer id);
    int deleteRole(Assist assist);
    int updateRoleById(Role enti);
    int updateRole(@Param("enti") Role value, @Param("assist") Assist assist);
    int updateNonEmptyRoleById(Role enti);
    int updateNonEmptyRole(@Param("enti") Role value, @Param("assist") Assist assist);
}