package com.miaoshaproject.error;

/**
 * @Author: WY
 * @Date: 2019/8/26 15:31
 */
public interface CommonError {
    public int getErrorCode();
    public String getErrorMsg();
    public CommonError setErrorMsg(String errorMsg);
}
