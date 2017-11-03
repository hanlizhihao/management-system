package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.CombinationProducts;

import java.util.List;

public interface CombinationProductsService{
    long getCombinationProductsRowCount(Assist assist);
    List<CombinationProducts> selectCombinationProducts(Assist assist);
    CombinationProducts selectCombinationProductsById(Integer id);
    int insertCombinationProducts(CombinationProducts value);
    int insertNonEmptyCombinationProducts(CombinationProducts value);
    int deleteCombinationProductsById(Integer id);
    int deleteCombinationProducts(Assist assist);
    int updateCombinationProductsById(CombinationProducts enti);
    int updateCombinationProducts(CombinationProducts value, Assist assist);
    int updateNonEmptyCombinationProductsById(CombinationProducts enti);
    int updateNonEmptyCombinationProducts(CombinationProducts value, Assist assist);
}