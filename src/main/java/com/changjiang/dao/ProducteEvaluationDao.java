package com.changjiang.dao;

import com.changjiang.common.Assist;
import com.changjiang.entity.ProducteEvaluation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProducteEvaluationDao{
    long getProducteEvaluationRowCount(Assist assist);
    List<ProducteEvaluation> selectProducteEvaluation(Assist assist);
    ProducteEvaluation selectProducteEvaluationById(Integer id);
    int insertProducteEvaluation(ProducteEvaluation value);
    int insertNonEmptyProducteEvaluation(ProducteEvaluation value);
    int deleteProducteEvaluationById(Integer id);
    int deleteProducteEvaluation(Assist assist);
    int updateProducteEvaluationById(ProducteEvaluation enti);
    int updateProducteEvaluation(@Param("enti") ProducteEvaluation value, @Param("assist") Assist assist);
    int updateNonEmptyProducteEvaluationById(ProducteEvaluation enti);
    int updateNonEmptyProducteEvaluation(@Param("enti") ProducteEvaluation value, @Param("assist") Assist assist);
}