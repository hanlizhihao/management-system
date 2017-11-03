package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.dao.ProducteEvaluationDao;
import com.changjiang.entity.ProducteEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducteEvaluationServiceImpl implements ProducteEvaluationService{
    @Autowired
	private ProducteEvaluationDao producteEvaluationDao;
    @Override
    public long getProducteEvaluationRowCount(Assist assist){
        return producteEvaluationDao.getProducteEvaluationRowCount(assist);
    }
    @Override
    public List<ProducteEvaluation> selectProducteEvaluation(Assist assist){
        return producteEvaluationDao.selectProducteEvaluation(assist);
    }
    @Override
    public ProducteEvaluation selectProducteEvaluationById(Integer id){
        return producteEvaluationDao.selectProducteEvaluationById(id);
    }
    @Override
    public int insertProducteEvaluation(ProducteEvaluation value){
        return producteEvaluationDao.insertProducteEvaluation(value);
    }
    @Override
    public int insertNonEmptyProducteEvaluation(ProducteEvaluation value){
        return producteEvaluationDao.insertNonEmptyProducteEvaluation(value);
    }
    @Override
    public int deleteProducteEvaluationById(Integer id){
        return producteEvaluationDao.deleteProducteEvaluationById(id);
    }
    @Override
    public int deleteProducteEvaluation(Assist assist){
        return producteEvaluationDao.deleteProducteEvaluation(assist);
    }
    @Override
    public int updateProducteEvaluationById(ProducteEvaluation enti){
        return producteEvaluationDao.updateProducteEvaluationById(enti);
    }
    @Override
    public int updateProducteEvaluation(ProducteEvaluation value, Assist assist){
        return producteEvaluationDao.updateProducteEvaluation(value,assist);
    }
    @Override
    public int updateNonEmptyProducteEvaluationById(ProducteEvaluation enti){
        return producteEvaluationDao.updateNonEmptyProducteEvaluationById(enti);
    }
    @Override
    public int updateNonEmptyProducteEvaluation(ProducteEvaluation value, Assist assist){
        return producteEvaluationDao.updateNonEmptyProducteEvaluation(value,assist);
    }

    public ProducteEvaluationDao getProducteEvaluationDao() {
        return this.producteEvaluationDao;
    }

    public void setProducteEvaluationDao(ProducteEvaluationDao producteEvaluationDao) {
        this.producteEvaluationDao = producteEvaluationDao;
    }

}