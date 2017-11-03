package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.Function;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionDao{
    long getFunctionRowCount(Assist assist);
    List<Function> selectFunction(Assist assist);
    Function selectFunctionById(Integer id);
    int insertFunction(Function value);
    int insertNonEmptyFunction(Function value);
    int deleteFunctionById(Integer id);
    int deleteFunction(Assist assist);
    int updateFunctionById(Function enti);
    int updateFunction(@Param("enti") Function value, @Param("assist") Assist assist);
    int updateNonEmptyFunctionById(Function enti);
    int updateNonEmptyFunction(@Param("enti") Function value, @Param("assist") Assist assist);
    
}