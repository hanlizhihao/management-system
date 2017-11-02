package com.changjiang.service;

import com.changjiang.common.Assist;
import com.changjiang.entity.Privilege;

import java.util.List;

public interface PrivilegeService{
    long getPrivilegeRowCount(Assist assist);
    List<Privilege> selectPrivilege(Assist assist);
    Privilege selectPrivilegeById(Integer id);
    int insertPrivilege(Privilege value);
    int insertNonEmptyPrivilege(Privilege value);
    int deletePrivilegeById(Integer id);
    int deletePrivilege(Assist assist);
    int updatePrivilegeById(Privilege enti);
    int updatePrivilege(Privilege value, Assist assist);
    int updateNonEmptyPrivilegeById(Privilege enti);
    int updateNonEmptyPrivilege(Privilege value, Assist assist);
}