package com.zxy.dao.user;

import com.zxy.entity.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User loginQuery(String mobile);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}