package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.OrderModel;

/**
 * @Author: WY
 * @Date: 2019/8/28 17:00
 */
public interface OrderService {
    /**
     * @param userId
     * @param itemId
     * @param amount
     * @return
     */
    OrderModel createOrder(Integer userId,Integer itemId,Integer amount) throws BusinessException;

    /**
     * 生成订单号
     */
    String generateOrderNum();
}
