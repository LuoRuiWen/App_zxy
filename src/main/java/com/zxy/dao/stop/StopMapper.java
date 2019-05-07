package com.zxy.dao.stop;

import com.zxy.entity.stop.Stop;

import java.util.List;

public interface StopMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Stop record);

    int insertSelective(Stop record);

    Stop selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Stop record);

    int updateByPrimaryKey(Stop record);

    List<Stop> findByTid(String tid);
}