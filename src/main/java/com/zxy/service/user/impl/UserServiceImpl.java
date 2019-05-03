package com.zxy.service.user.impl;

import com.zxy.dao.user.UserDao;
import com.zxy.entity.user.User;
import com.zxy.model.user.form.UserRegisterForm;
import com.zxy.service.user.UserService;
import com.zxy.utils.IdUtils;
import com.zxy.utils.ResultData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public ResultData userRegister(UserRegisterForm form) {
        User user = new User();
        BeanUtils.copyProperties(form,user);
        String id = IdUtils.nextId();
        user.setId(id);
        //int result = userMapper.userRegister(user);
        int result = 1;
        return ResultData.ok(result);
    }
}
