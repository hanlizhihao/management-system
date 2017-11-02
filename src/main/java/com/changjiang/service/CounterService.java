package com.changjiang.service;

import com.changjiang.common.Assist;
import com.changjiang.entity.Counter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CounterService{
    long getCounterRowCount(Assist assist);
    List<Counter> selectCounter(Assist assist);
    Counter selectCounterById(Integer id);
    int insertCounter(Counter value);
    int insertNonEmptyCounter(Counter value);
    int deleteCounterById(Integer id);
    int deleteCounter(Assist assist);
    int updateCounterById(Counter enti);
    int updateCounter(Counter value, Assist assist);
    int updateNonEmptyCounterById(Counter enti);
    int updateNonEmptyCounter(Counter value, Assist assist);
    /**
	 * 通过id查询柜台及其对应的柜台岗位记录
	 */
    List<Counter> findfindCounterAndWorkStationRecord(Integer id);
}