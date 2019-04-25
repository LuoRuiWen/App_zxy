package com.zxy.dao.user;

import com.zxy.entity.user.user;

public interface userMapper {
    int deleteByPrimaryKey(String id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}