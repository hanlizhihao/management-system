package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.RolePower;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RolePowerDao{
    long getRolePowerRowCount(Assist assist);
    List<RolePower> selectRolePower(Assist assist);
    RolePower selectRolePowerById(Integer id);
    int insertRolePower(RolePower value);
    int insertNonEmptyRolePower(RolePower value);
    int deleteRolePowerById(Integer id);
    int deleteRolePower(Assist assist);
    int updateRolePowerById(RolePower enti);
    int updateRolePower(@Param("enti") RolePower value, @Param("assist") Assist assist);
    int updateNonEmptyRolePowerById(RolePower enti);
    int updateNonEmptyRolePower(@Param("enti") RolePower value, @Param("assist") Assist assist);
    @Select("select * from role_power where role_id=#{role_id}")
    @Results({
    	@Result(id=true,column="id",property="id"),
    	@Result(column="role_id",property="roleId"),
    	@Result(column="function_name",property="functionName"),
    	@Result(column="function_id",property="function",
    	one=@One(select="com.changjiang.dao.FunctionDao.selectFunctionById",
    	fetchType=FetchType.EAGER)),
    })
    List<RolePower> selectRolePowerByRoleId(Integer role_id);
}