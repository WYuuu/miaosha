package com.miaoshaproject.controller;

import com.alibaba.druid.util.StringUtils;
import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @Author: WY
 * @Date: 2019/8/26 14:22
 * controller做了到UserVO之间的传输,保证了UI只展示它所需要的字段
 */
@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

//      用户登录接口
@ResponseBody
@RequestMapping(value = "/login", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    public CommonReturnType login(@RequestParam(name = "telphone") String telphone,
                                  @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

//    入参校验
    if (org.apache.commons.lang3.StringUtils.isEmpty(telphone)
            || org.apache.commons.lang3.StringUtils.isEmpty(password)){
        throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
    }

//    用户登录服务,用来校验用户登录是否合法
    UserModel userModel = userService.validateLogin(telphone, this.encodeByMD5(password));

//      将登陆凭证加入到用户登陆成功的session内
    this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
    this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userModel);

    return CommonReturnType.create(null);
}



//      用户注册接口
@ResponseBody
@RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    public CommonReturnType register(@RequestParam(name = "telphone") String telphone,
                                     @RequestParam(name = "otpCode") String otpCode,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "gender") String gender,
                                     @RequestParam(name = "age") Integer age,
                                     @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

//        验证手机号和对应的otpCode相符合
        String inSessionOtpCode =(String) this.httpServletRequest.getSession().getAttribute(telphone);
        if (!StringUtils.equals(otpCode, inSessionOtpCode)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"短信验证码不符合");
        }
//        用户注册流程
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(Byte.valueOf(gender));
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setRegisterMode("bywechat");
        userModel.setEncrptPassword(this.encodeByMD5(password));

        userService.register(userModel);
        return CommonReturnType.create(null);
    }

    public String encodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//      确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
//        加密字符串
        String newstr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

//      用户获取otp短信的接口
    @ResponseBody
    @RequestMapping(value = "/getotp", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    public CommonReturnType getOtp(@RequestParam(name = "telphone") String telphone){

//        需要按照一定规则生成otp验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

//        将otp验证码同对应用户的手机号码关联,使用httpSession的方式绑定手机号与otpCode
        httpServletRequest.getSession().setAttribute(telphone,otpCode);

//        将otp验证码通过短信发送给用户,省略
        System.out.println("telphone = " + telphone + "&otpCode" + otpCode);


        return CommonReturnType.create(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    private CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
//        调用service服务获取对应id的用户对象，并返回给前端
        UserModel userModel = userService.getUserById(id);

//          若获取的用户信息不存在
        if (userModel == null){
            userModel.setEncrptPassword("123");
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

//        将核心领域的模型用户对象转化为可供UI使用的viewObject
        UserVO userVO = convertFromModel(userModel);

//        返回通用对象
        return CommonReturnType.create(userVO);
    }

    public UserVO convertFromModel(UserModel userModel){
        if (userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;

    }
}
