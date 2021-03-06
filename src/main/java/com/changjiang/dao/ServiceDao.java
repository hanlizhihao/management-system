package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceDao{
    long getServiceRowCount(Assist assist);
    List<Service> selectService(Assist assist);
    Service selectServiceById(Integer id);
    int insertService(Service value);
    int insertNonEmptyService(Service value);
    int deleteServiceById(Integer id);
    int deleteService(Assist assist);
    int updateServiceById(Service enti);
    int updateService(@Param("enti") Service value, @Param("assist") Assist assist);
    int updateNonEmptyServiceById(Service enti);
    int updateNonEmptyService(@Param("enti") Service value, @Param("assist") Assist assist);
}