package com.miaoshaproject.controller.viewobject;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * @Author: WY
 * @Date: 2019/8/27 17:46
 */
@Getter
@Setter
public class ItemVO {
    private Integer id;
    private String title;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private Integer sales;
    private String imgUrl;

//    商品是否在秒杀活动中，及对应状态,0:没有秒杀活动，1：秒杀活动待开始，2：秒杀活动进行中
    private Integer promoStatus;

//    秒杀活动价
    private BigDecimal promoPrice;

//    秒杀活动ID
    private Integer promoId;

//    秒杀活动开始时间
    private String startDate;
}
