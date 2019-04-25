package com.zxy.dao.user;

import com.zxy.entity.user.SecurityEntity;

public interface SecurityEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(SecurityEntity record);

    int insertSelective(SecurityEntity record);

    SecurityEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SecurityEntity record);

    int updateByPrimaryKey(SecurityEntity record);
}