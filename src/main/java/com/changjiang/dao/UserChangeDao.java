package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.UserChange;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserChangeDao{
    long getUserChangeRowCount(Assist assist);
    List<UserChange> selectUserChange(Assist assist);
    UserChange selectUserChangeById(Integer id);
    int insertUserChange(UserChange value);
    int insertNonEmptyUserChange(UserChange value);
    int deleteUserChangeById(Integer id);
    int deleteUserChange(Assist assist);
    int updateUserChangeById(UserChange enti);
    int updateUserChange(@Param("enti") UserChange value, @Param("assist") Assist assist);
    int updateNonEmptyUserChangeById(UserChange enti);
    int updateNonEmptyUserChange(@Param("enti") UserChange value, @Param("assist") Assist assist);
}