package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.CounterWorkStationRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CounterWorkStationRecordDao{
    long getCounterWorkStationRecordRowCount(Assist assist);
    List<CounterWorkStationRecord> selectCounterWorkStationRecord(Assist assist);
    CounterWorkStationRecord selectCounterWorkStationRecordById(Integer id);
    int insertCounterWorkStationRecord(CounterWorkStationRecord value);
    int insertNonEmptyCounterWorkStationRecord(CounterWorkStationRecord value);
    int deleteCounterWorkStationRecordById(Integer id);
    int deleteCounterWorkStationRecord(Assist assist);
    int updateCounterWorkStationRecordById(CounterWorkStationRecord enti);
    int updateCounterWorkStationRecord(@Param("enti") CounterWorkStationRecord value, @Param("assist") Assist assist);
    int updateNonEmptyCounterWorkStationRecordById(CounterWorkStationRecord enti);
    int updateNonEmptyCounterWorkStationRecord(@Param("enti") CounterWorkStationRecord value, @Param("assist") Assist assist);
}