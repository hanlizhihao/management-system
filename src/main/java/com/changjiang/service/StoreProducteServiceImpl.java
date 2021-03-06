package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.dao.StoreProducteDao;
import com.changjiang.entity.StoreProducte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreProducteServiceImpl implements StoreProducteService {
    @Autowired
	private StoreProducteDao storeProducteDao;
    @Override
    public long getStoreProducteRowCount(Assist assist){
        return storeProducteDao.getStoreProducteRowCount(assist);
    }
    @Override
    public List<StoreProducte> selectStoreProducte(Assist assist){
        return storeProducteDao.selectStoreProducte(assist);
    }
    @Override
    public StoreProducte selectStoreProducteById(Integer id){
        return storeProducteDao.selectStoreProducteById(id);
    }
    @Override
    public int insertStoreProducte(StoreProducte value){
        return storeProducteDao.insertStoreProducte(value);
    }
    @Override
    public int insertNonEmptyStoreProducte(StoreProducte value){
        return storeProducteDao.insertNonEmptyStoreProducte(value);
    }
    @Override
    public int deleteStoreProducteById(Integer id){
        return storeProducteDao.deleteStoreProducteById(id);
    }
    @Override
    public int deleteStoreProducte(Assist assist){
        return storeProducteDao.deleteStoreProducte(assist);
    }
    @Override
    public int updateStoreProducteById(StoreProducte enti){
        return storeProducteDao.updateStoreProducteById(enti);
    }
    @Override
    public int updateStoreProducte(StoreProducte value, Assist assist){
        return storeProducteDao.updateStoreProducte(value,assist);
    }
    @Override
    public int updateNonEmptyStoreProducteById(StoreProducte enti){
        return storeProducteDao.updateNonEmptyStoreProducteById(enti);
    }
    @Override
    public int updateNonEmptyStoreProducte(StoreProducte value, Assist assist){
        return storeProducteDao.updateNonEmptyStoreProducte(value,assist);
    }

    public StoreProducteDao getStoreProducteDao() {
        return this.storeProducteDao;
    }

    public void setStoreProducteDao(StoreProducteDao storeProducteDao) {
        this.storeProducteDao = storeProducteDao;
    }

}