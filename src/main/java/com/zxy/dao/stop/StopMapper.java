package com.zxy.dao.stop;

import com.zxy.entity.stop.Stop;

public interface StopMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Stop record);

    int insertSelective(Stop record);

    Stop selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Stop record);

    int updateByPrimaryKey(Stop record);
}