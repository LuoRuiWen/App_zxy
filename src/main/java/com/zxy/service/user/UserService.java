package com.zxy.service.user;

import com.zxy.model.user.form.UserLoginForm;
import com.zxy.model.user.form.UserRegisterForm;
import com.zxy.utils.ResultData;

public interface UserService {
    ResultData userRegister(UserRegisterForm form);

    ResultData userLogin(UserLoginForm form);
}
