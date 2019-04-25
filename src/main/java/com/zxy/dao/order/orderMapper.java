package com.zxy.dao.order;

import com.zxy.entity.order.order;

public interface orderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(order record);

    int insertSelective(order record);

    order selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(order record);

    int updateByPrimaryKey(order record);
}