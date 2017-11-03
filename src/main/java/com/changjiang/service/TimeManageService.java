package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.TimeManage;

import java.util.List;

public interface TimeManageService{
    long getTimeManageRowCount(Assist assist);
    List<TimeManage> selectTimeManage(Assist assist);
    TimeManage selectTimeManageById(Integer id);
    int insertTimeManage(TimeManage value);
    int insertNonEmptyTimeManage(TimeManage value);
    int deleteTimeManageById(Integer id);
    int deleteTimeManage(Assist assist);
    int updateTimeManageById(TimeManage enti);
    int updateTimeManage(TimeManage value, Assist assist);
    int updateNonEmptyTimeManageById(TimeManage enti);
    int updateNonEmptyTimeManage(TimeManage value, Assist assist);
}