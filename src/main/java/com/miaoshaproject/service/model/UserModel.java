package com.miaoshaproject.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: WY
 * @Date: 2019/8/26 14:31
 */
@Setter
@Getter
public class UserModel {
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotNull(message = "性别必须填写")
    private Byte gender;

    @NotNull(message = "年龄必须填写")
    @Min(value = 0,message = "年龄必须大于0")
    @Max(value = 150,message = "年龄必须小于150岁")
    private Integer age;

    @NotBlank(message = "手机号码不能为空")
    private String telphone;

    private String registerMode;
    private String thirdPartyId;

    @NotBlank(message = "密码不能为空")
    private String encrptPassword;
}
