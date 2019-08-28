package com.miaoshaproject.controller.viewobject;

import lombok.Getter;
import lombok.Setter;

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
}
