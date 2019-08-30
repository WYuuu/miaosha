package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/** 定义exception handler解决未被controller层吸收的exception
 * @Author: WY
 * @Date: 2019/8/26 16:47
 */
public class BaseController {
    public static final String CONTENT_TYPE_FORMED="application/x-www-form-urlencoded";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception e){
        Map<String,Object> responseData = new HashMap<>();

        if (e instanceof BusinessException){
            BusinessException businessException = (BusinessException)e;
            responseData.put("errorCode",businessException.getErrorCode());
            responseData.put("errorMsg", businessException.getErrorMsg());
        }else {
            responseData.put("errorCode", EmBusinessError.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errorMsg", EmBusinessError.UNKNOWN_ERROR.getErrorMsg());
        }
        return CommonReturnType.create(responseData,"FAIL");
    }
}
