package com.zxy.dao.stop;

import com.zxy.entity.stop.stop;

public interface stopMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(stop record);

    int insertSelective(stop record);

    stop selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(stop record);

    int updateByPrimaryKey(stop record);
}