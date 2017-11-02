package com.changjiang.dao;

import com.changjiang.common.Assist;
import com.changjiang.entity.ProducteSpeciality;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProducteSpecialityDao{
    long getProducteSpecialityRowCount(Assist assist);
    List<ProducteSpeciality> selectProducteSpeciality(Assist assist);
    ProducteSpeciality selectProducteSpecialityById(Integer id);
    int insertProducteSpeciality(ProducteSpeciality value);
    int insertNonEmptyProducteSpeciality(ProducteSpeciality value);
    int deleteProducteSpecialityById(Integer id);
    int deleteProducteSpeciality(Assist assist);
    int updateProducteSpecialityById(ProducteSpeciality enti);
    int updateProducteSpeciality(@Param("enti") ProducteSpeciality value, @Param("assist") Assist assist);
    int updateNonEmptyProducteSpecialityById(ProducteSpeciality enti);
    int updateNonEmptyProducteSpeciality(@Param("enti") ProducteSpeciality value, @Param("assist") Assist assist);
}