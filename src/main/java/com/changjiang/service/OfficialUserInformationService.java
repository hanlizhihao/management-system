package com.changjiang.service;

import com.changjiang.common.Assist;
import com.changjiang.entity.OfficialUserInformation;

import java.util.List;

public interface OfficialUserInformationService{
    long getOfficialUserInformationRowCount(Assist assist);
    List<OfficialUserInformation> selectOfficialUserInformation(Assist assist);
    OfficialUserInformation selectOfficialUserInformationById(Integer id);
    int insertOfficialUserInformation(OfficialUserInformation value);
    int insertNonEmptyOfficialUserInformation(OfficialUserInformation value);
    int deleteOfficialUserInformationById(Integer id);
    int deleteOfficialUserInformation(Assist assist);
    int updateOfficialUserInformationById(OfficialUserInformation enti);
    int updateOfficialUserInformation(OfficialUserInformation value, Assist assist);
    int updateNonEmptyOfficialUserInformationById(OfficialUserInformation enti);
    int updateNonEmptyOfficialUserInformation(OfficialUserInformation value, Assist assist);
}