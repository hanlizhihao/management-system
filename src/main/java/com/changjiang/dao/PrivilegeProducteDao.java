package com.changjiang.dao;

import com.changjiang.common.Assist;
import com.changjiang.entity.PrivilegeProducte;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivilegeProducteDao{
    long getPrivilegeProducteRowCount(Assist assist);
    List<PrivilegeProducte> selectPrivilegeProducte(Assist assist);
    PrivilegeProducte selectPrivilegeProducteById(Integer id);
    int insertPrivilegeProducte(PrivilegeProducte value);
    int insertNonEmptyPrivilegeProducte(PrivilegeProducte value);
    int deletePrivilegeProducteById(Integer id);
    int deletePrivilegeProducte(Assist assist);
    int updatePrivilegeProducteById(PrivilegeProducte enti);
    int updatePrivilegeProducte(@Param("enti") PrivilegeProducte value, @Param("assist") Assist assist);
    int updateNonEmptyPrivilegeProducteById(PrivilegeProducte enti);
    int updateNonEmptyPrivilegeProducte(@Param("enti") PrivilegeProducte value, @Param("assist") Assist assist);
}