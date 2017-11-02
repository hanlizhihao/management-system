package com.changjiang.service;

import com.changjiang.common.Assist;
import com.changjiang.entity.ServiceType;

import java.util.List;

public interface ServiceTypeService{
    long getServiceTypeRowCount(Assist assist);
    List<ServiceType> selectServiceType(Assist assist);
    ServiceType selectServiceTypeById(Integer id);
    int insertServiceType(ServiceType value);
    int insertNonEmptyServiceType(ServiceType value);
    int deleteServiceTypeById(Integer id);
    int deleteServiceType(Assist assist);
    int updateServiceTypeById(ServiceType enti);
    int updateServiceType(ServiceType value, Assist assist);
    int updateNonEmptyServiceTypeById(ServiceType enti);
    int updateNonEmptyServiceType(ServiceType value, Assist assist);
}