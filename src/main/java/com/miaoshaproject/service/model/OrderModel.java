package com.miaoshaproject.service.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**用户下单的交易模型
 * @Author: WY
 * @Date: 2019/8/28 16:44
 */
@Getter
@Setter
public class OrderModel {
    /**
     * 订单号
     */
    private String id;

    /**
     * 下单用户的ID
     */
    private Integer userId;

    /**
     * 所购商品的ID
     */
    private Integer itemId;

    /**
     * 所购商品的单价
     */
    private BigDecimal itemPrice;

    /**
     * 购买数量
     */
    private Integer amount;

    /**
     * 下单总金额
     */
    private BigDecimal totalPrice;
}
