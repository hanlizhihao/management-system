package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaDao{
    long getAreaRowCount(Assist assist);
    List<Area> selectArea(Assist assist);
    Area selectAreaById(Integer id);
    int insertArea(Area value);
    int insertNonEmptyArea(Area value);
    int deleteAreaById(Integer id);
    int deleteArea(Assist assist);
    int updateAreaById(Area enti);
    int updateArea(@Param("enti") Area value, @Param("assist") Assist assist);
    int updateNonEmptyAreaById(Area enti);
    int updateNonEmptyArea(@Param("enti") Area value, @Param("assist") Assist assist);
    /**
	 * 查询区域以及区域下的柜台
	 */
    List<Area> findAreaAndCounter(Integer id);
}