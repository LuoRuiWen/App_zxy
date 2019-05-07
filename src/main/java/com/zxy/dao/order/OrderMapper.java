package com.zxy.dao.order;

import com.zxy.entity.order.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String oid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String oid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> findAll(String uid);

    void refund(String oid);
}