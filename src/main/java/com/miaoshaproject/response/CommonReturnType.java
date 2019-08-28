package com.miaoshaproject.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: WY
 * @Date: 2019/8/26 15:18
 */
@Setter
@Getter
public class CommonReturnType {
//    表明对应请求的返回处理结果，有"success" 或 "fail"
    private String status;

//    若status=success,则data内返回需要的json数据
//    若status=fail,则返回通用的错误码格式
    private Object data;

//    定义一个通用的创建方法
    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result, String status){
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);

        return type;
    }
}
