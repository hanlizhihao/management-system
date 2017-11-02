package com.changjiang.dao;

import com.changjiang.common.Assist;
import com.changjiang.entity.CombinationProductsRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CombinationProductsRecordDao{
    long getCombinationProductsRecordRowCount(Assist assist);
    List<CombinationProductsRecord> selectCombinationProductsRecord(Assist assist);
    CombinationProductsRecord selectCombinationProductsRecordById(Integer id);
    int insertCombinationProductsRecord(CombinationProductsRecord value);
    int insertNonEmptyCombinationProductsRecord(CombinationProductsRecord value);
    int deleteCombinationProductsRecordById(Integer id);
    int deleteCombinationProductsRecord(Assist assist);
    int updateCombinationProductsRecordById(CombinationProductsRecord enti);
    int updateCombinationProductsRecord(@Param("enti") CombinationProductsRecord value, @Param("assist") Assist assist);
    int updateNonEmptyCombinationProductsRecordById(CombinationProductsRecord enti);
    int updateNonEmptyCombinationProductsRecord(@Param("enti") CombinationProductsRecord value, @Param("assist") Assist assist);
}