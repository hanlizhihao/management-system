package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.dao.CombinationProductsDao;
import com.changjiang.entity.CombinationProducts;

import java.util.List;

public class CombinationProductsServiceImpl implements CombinationProductsService {
    private CombinationProductsDao combinationProductsDao;
    @Override
    public long getCombinationProductsRowCount(Assist assist){
        return combinationProductsDao.getCombinationProductsRowCount(assist);
    }
    @Override
    public List<CombinationProducts> selectCombinationProducts(Assist assist){
        return combinationProductsDao.selectCombinationProducts(assist);
    }
    @Override
    public CombinationProducts selectCombinationProductsById(Integer id){
        return combinationProductsDao.selectCombinationProductsById(id);
    }
    @Override
    public int insertCombinationProducts(CombinationProducts value){
        return combinationProductsDao.insertCombinationProducts(value);
    }
    @Override
    public int insertNonEmptyCombinationProducts(CombinationProducts value){
        return combinationProductsDao.insertNonEmptyCombinationProducts(value);
    }
    @Override
    public int deleteCombinationProductsById(Integer id){
        return combinationProductsDao.deleteCombinationProductsById(id);
    }
    @Override
    public int deleteCombinationProducts(Assist assist){
        return combinationProductsDao.deleteCombinationProducts(assist);
    }
    @Override
    public int updateCombinationProductsById(CombinationProducts enti){
        return combinationProductsDao.updateCombinationProductsById(enti);
    }
    @Override
    public int updateCombinationProducts(CombinationProducts value, Assist assist){
        return combinationProductsDao.updateCombinationProducts(value,assist);
    }
    @Override
    public int updateNonEmptyCombinationProductsById(CombinationProducts enti){
        return combinationProductsDao.updateNonEmptyCombinationProductsById(enti);
    }
    @Override
    public int updateNonEmptyCombinationProducts(CombinationProducts value, Assist assist){
        return combinationProductsDao.updateNonEmptyCombinationProducts(value,assist);
    }

    public CombinationProductsDao getCombinationProductsDao() {
        return this.combinationProductsDao;
    }

    public void setCombinationProductsDao(CombinationProductsDao combinationProductsDao) {
        this.combinationProductsDao = combinationProductsDao;
    }

}