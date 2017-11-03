package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.Privilege;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivilegeDao{
    long getPrivilegeRowCount(Assist assist);
    List<Privilege> selectPrivilege(Assist assist);
    Privilege selectPrivilegeById(Integer id);
    int insertPrivilege(Privilege value);
    int insertNonEmptyPrivilege(Privilege value);
    int deletePrivilegeById(Integer id);
    int deletePrivilege(Assist assist);
    int updatePrivilegeById(Privilege enti);
    int updatePrivilege(@Param("enti") Privilege value, @Param("assist") Assist assist);
    int updateNonEmptyPrivilegeById(Privilege enti);
    int updateNonEmptyPrivilege(@Param("enti") Privilege value, @Param("assist") Assist assist);
}