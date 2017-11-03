package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.OrderProducte;

import java.util.List;

public interface OrderProducteService{
    long getOrderProducteRowCount(Assist assist);
    List<OrderProducte> selectOrderProducte(Assist assist);
    OrderProducte selectOrderProducteById(Integer id);
    int insertOrderProducte(OrderProducte value);
    int insertNonEmptyOrderProducte(OrderProducte value);
    int deleteOrderProducteById(Integer id);
    int deleteOrderProducte(Assist assist);
    int updateOrderProducteById(OrderProducte enti);
    int updateOrderProducte(OrderProducte value, Assist assist);
    int updateNonEmptyOrderProducteById(OrderProducte enti);
    int updateNonEmptyOrderProducte(OrderProducte value, Assist assist);
}