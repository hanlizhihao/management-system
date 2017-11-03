package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.TimeManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TimeManageDao{
    long getTimeManageRowCount(Assist assist);
    List<TimeManage> selectTimeManage(Assist assist);
    TimeManage selectTimeManageById(Integer id);
    int insertTimeManage(TimeManage value);
    int insertNonEmptyTimeManage(TimeManage value);
    int deleteTimeManageById(Integer id);
    int deleteTimeManage(Assist assist);
    int updateTimeManageById(TimeManage enti);
    int updateTimeManage(@Param("enti") TimeManage value, @Param("assist") Assist assist);
    int updateNonEmptyTimeManageById(TimeManage enti);
    int updateNonEmptyTimeManage(@Param("enti") TimeManage value, @Param("assist") Assist assist);
}