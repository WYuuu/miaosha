package com.miaoshaproject.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Author: WY
 * @Date: 2019/8/27 11:08
 */
@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

//    实现校验方法，并返回校验结果
    public ValidationResult validate(Object bean){
        ValidationResult result = new ValidationResult();
//        若对应bean中的一些参数违反了validation定义的annotation的规则，则将值放入set对象中
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size() > 0){
//            大于0表示有错
            result.setHasErrors(true);
            constraintViolationSet.forEach(constraintViolation ->{
                String errorMsg = constraintViolation.getMessage();
                String propertyName = constraintViolation.getPropertyPath().toString();
                result.getErrorMsgMap().put(propertyName, errorMsg);
            });
        }
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        将hibernate通过工厂的初始化方式使其实例化
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}
