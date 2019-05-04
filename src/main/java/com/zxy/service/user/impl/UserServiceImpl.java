package com.zxy.service.user.impl;

import com.zxy.dao.user.UserMapper;
import com.zxy.entity.user.User;
import com.zxy.model.user.form.UserLoginForm;
import com.zxy.model.user.form.UserRegisterForm;
import com.zxy.service.user.UserService;
import com.zxy.utils.IdUtils;
import com.zxy.utils.ResultData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired/*(required = false)*/
    private UserMapper userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncorder;

    @Override
    public ResultData userRegister(UserRegisterForm form) {
        User user = new User();
        BeanUtils.copyProperties(form,user);
        String id = IdUtils.nextId();
        user.setId(id);
        user.setCreateTime(new Date());
        user.setUserPwd(passwordEncorder.encode(form.getUserPwd()));
        int result = userDao.insert(user);
        //int result = 1;
        return ResultData.ok(result);
    }

    public ResultData userLogin(UserLoginForm form){
        User user = userDao.loginQuery(form.getMobile());
        if(!user.getUserPwd().equals(passwordEncorder.encode(form.getPassword()))){
            return ResultData.error(501,"密码错误！");
        }
        return ResultData.ok(0);
    }
}
