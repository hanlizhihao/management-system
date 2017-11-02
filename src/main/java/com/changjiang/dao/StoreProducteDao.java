package com.changjiang.dao;

import com.changjiang.common.Assist;
import com.changjiang.entity.StoreProducte;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreProducteDao{
    long getStoreProducteRowCount(Assist assist);
    List<StoreProducte> selectStoreProducte(Assist assist);
    StoreProducte selectStoreProducteById(Integer id);
    int insertStoreProducte(StoreProducte value);
    int insertNonEmptyStoreProducte(StoreProducte value);
    int deleteStoreProducteById(Integer id);
    int deleteStoreProducte(Assist assist);
    int updateStoreProducteById(StoreProducte enti);
    int updateStoreProducte(@Param("enti") StoreProducte value, @Param("assist") Assist assist);
    int updateNonEmptyStoreProducteById(StoreProducte enti);
    int updateNonEmptyStoreProducte(@Param("enti") StoreProducte value, @Param("assist") Assist assist);
}