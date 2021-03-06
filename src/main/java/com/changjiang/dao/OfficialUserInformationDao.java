package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.OfficialUserInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfficialUserInformationDao{
    long getOfficialUserInformationRowCount(Assist assist);
    List<OfficialUserInformation> selectOfficialUserInformation(Assist assist);
    OfficialUserInformation selectOfficialUserInformationById(Integer id);
    int insertOfficialUserInformation(OfficialUserInformation value);
    int insertNonEmptyOfficialUserInformation(OfficialUserInformation value);
    int deleteOfficialUserInformationById(Integer id);
    int deleteOfficialUserInformation(Assist assist);
    int updateOfficialUserInformationById(OfficialUserInformation enti);
    int updateOfficialUserInformation(@Param("enti") OfficialUserInformation value, @Param("assist") Assist assist);
    int updateNonEmptyOfficialUserInformationById(OfficialUserInformation enti);
    int updateNonEmptyOfficialUserInformation(@Param("enti") OfficialUserInformation value, @Param("assist") Assist assist);
}