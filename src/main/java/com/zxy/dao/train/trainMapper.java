package com.zxy.dao.train;

import com.zxy.entity.train.train;

public interface trainMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(train record);

    int insertSelective(train record);

    train selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(train record);

    int updateByPrimaryKey(train record);
}