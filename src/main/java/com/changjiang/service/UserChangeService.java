package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.UserChange;

import java.util.List;

public interface UserChangeService{
    long getUserChangeRowCount(Assist assist);
    List<UserChange> selectUserChange(Assist assist);
    UserChange selectUserChangeById(Integer id);
    int insertUserChange(UserChange value);
    int insertNonEmptyUserChange(UserChange value);
    int deleteUserChangeById(Integer id);
    int deleteUserChange(Assist assist);
    int updateUserChangeById(UserChange enti);
    int updateUserChange(UserChange value, Assist assist);
    int updateNonEmptyUserChangeById(UserChange enti);
    int updateNonEmptyUserChange(UserChange value, Assist assist);
}