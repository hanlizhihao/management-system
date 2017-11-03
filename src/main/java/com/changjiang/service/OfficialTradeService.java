package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.OfficialTrade;

import java.util.List;

public interface OfficialTradeService{
    long getOfficialTradeRowCount(Assist assist);
    List<OfficialTrade> selectOfficialTrade(Assist assist);
    OfficialTrade selectOfficialTradeById(Integer id);
    int insertOfficialTrade(OfficialTrade value);
    int insertNonEmptyOfficialTrade(OfficialTrade value);
    int deleteOfficialTradeById(Integer id);
    int deleteOfficialTrade(Assist assist);
    int updateOfficialTradeById(OfficialTrade enti);
    int updateOfficialTrade(OfficialTrade value, Assist assist);
    int updateNonEmptyOfficialTradeById(OfficialTrade enti);
    int updateNonEmptyOfficialTrade(OfficialTrade value, Assist assist);
    
}