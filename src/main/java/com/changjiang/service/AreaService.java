package com.changjiang.service;

import com.changjiang.common.Assist;
import com.changjiang.entity.Area;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaService{
    long getAreaRowCount(Assist assist);
    List<Area> selectArea(Assist assist);
    Area selectAreaById(Integer id);
    int insertArea(Area value);
    int insertNonEmptyArea(Area value);
    int deleteAreaById(Integer id);
    int deleteArea(Assist assist);
    int updateAreaById(Area enti);
    int updateArea(Area value, Assist assist);
    int updateNonEmptyAreaById(Area enti);
    int updateNonEmptyArea(Area value, Assist assist);
    /**
	 * 查询区域以及区域下的柜台
	 */
    List<Area> findAreaAndCounter(Integer id);
}