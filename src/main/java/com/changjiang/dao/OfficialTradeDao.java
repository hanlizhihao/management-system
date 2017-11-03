package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.OfficialTrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfficialTradeDao{
    long getOfficialTradeRowCount(Assist assist);
    List<OfficialTrade> selectOfficialTrade(Assist assist);
    OfficialTrade selectOfficialTradeById(Integer id);
    int insertOfficialTrade(OfficialTrade value);
    int insertNonEmptyOfficialTrade(OfficialTrade value);
    int deleteOfficialTradeById(Integer id);
    int deleteOfficialTrade(Assist assist);
    int updateOfficialTradeById(OfficialTrade enti);
    int updateOfficialTrade(@Param("enti") OfficialTrade value, @Param("assist") Assist assist);
    int updateNonEmptyOfficialTradeById(OfficialTrade enti);
    int updateNonEmptyOfficialTrade(@Param("enti") OfficialTrade value, @Param("assist") Assist assist);
}