package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;

/**
 * @Author: WY
 * @Date: 2019/8/26 14:26
 */
public interface UserService {
/** 通过用户ID获取用户对象*/
    UserModel getUserById(Integer id);
    void register(UserModel userModel) throws BusinessException;


    /**
     * telphone:用户注册手机
     * password：用户加密后的密码
     * */
    UserModel validateLogin(String telphone,String encrptPassword) throws BusinessException;
}
