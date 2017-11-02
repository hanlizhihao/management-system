package com.changjiang.service;

import com.changjiang.common.Assist;
import com.changjiang.entity.CounterWorkStationRecord;

import java.util.List;

public interface CounterWorkStationRecordService{
    long getCounterWorkStationRecordRowCount(Assist assist);
    List<CounterWorkStationRecord> selectCounterWorkStationRecord(Assist assist);
    CounterWorkStationRecord selectCounterWorkStationRecordById(Integer id);
    int insertCounterWorkStationRecord(CounterWorkStationRecord value);
    int insertNonEmptyCounterWorkStationRecord(CounterWorkStationRecord value);
    int deleteCounterWorkStationRecordById(Integer id);
    int deleteCounterWorkStationRecord(Assist assist);
    int updateCounterWorkStationRecordById(CounterWorkStationRecord enti);
    int updateCounterWorkStationRecord(CounterWorkStationRecord value, Assist assist);
    int updateNonEmptyCounterWorkStationRecordById(CounterWorkStationRecord enti);
    int updateNonEmptyCounterWorkStationRecord(CounterWorkStationRecord value, Assist assist);
}