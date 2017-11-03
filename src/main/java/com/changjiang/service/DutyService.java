package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.Duty;

import java.util.List;

public interface DutyService{
    long getDutyRowCount(Assist assist);
    List<Duty> selectDuty(Assist assist);
    Duty selectDutyById(Integer id);
    int insertDuty(Duty value);
    int insertNonEmptyDuty(Duty value);
    int deleteDutyById(Integer id);
    int deleteDuty(Assist assist);
    int updateDutyById(Duty enti);
    int updateDuty(Duty value, Assist assist);
    int updateNonEmptyDutyById(Duty enti);
    int updateNonEmptyDuty(Duty value, Assist assist);
    /**
     * 通过id查询duty以及其下的userinfomation
     * @param id
     * @return
     */
	List<Duty> findDutyAndUserInfo(Integer id);
	List<Duty> selectDutyByStoreNumber(String storeNumber);
}