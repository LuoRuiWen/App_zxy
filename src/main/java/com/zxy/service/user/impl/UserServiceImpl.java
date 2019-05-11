package com.zxy.service.user.impl;

import com.zxy.dao.user.UserMapper;
import com.zxy.entity.user.User;
import com.zxy.model.user.form.UserLoginForm;
import com.zxy.model.user.form.UserRegisterForm;
import com.zxy.service.user.UserService;
import com.zxy.utils.IdUtils;
import com.zxy.utils.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
        if(user==null){
            return ResultData.error(501,"用户不存在！");
        }
        if(!passwordEncorder.matches(form.getPassword(),user.getUserPwd())){
            return ResultData.error(501,"密码错误！");
        }
        return ResultData.ok(user);
    }
}
