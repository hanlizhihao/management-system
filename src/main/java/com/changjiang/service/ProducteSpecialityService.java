package com.changjiang.service;

import com.changjiang.common.Assist;
import com.changjiang.entity.ProducteSpeciality;

import java.util.List;

public interface ProducteSpecialityService{
    long getProducteSpecialityRowCount(Assist assist);
    List<ProducteSpeciality> selectProducteSpeciality(Assist assist);
    ProducteSpeciality selectProducteSpecialityById(Integer id);
    int insertProducteSpeciality(ProducteSpeciality value);
    int insertNonEmptyProducteSpeciality(ProducteSpeciality value);
    int deleteProducteSpecialityById(Integer id);
    int deleteProducteSpeciality(Assist assist);
    int updateProducteSpecialityById(ProducteSpeciality enti);
    int updateProducteSpeciality(ProducteSpeciality value, Assist assist);
    int updateNonEmptyProducteSpecialityById(ProducteSpeciality enti);
    int updateNonEmptyProducteSpeciality(ProducteSpeciality value, Assist assist);
}