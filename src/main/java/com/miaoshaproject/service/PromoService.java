package com.miaoshaproject.service;

import com.miaoshaproject.service.model.PromoModel;

/**
 * @Author: WY
 * @Date: 2019/8/30 10:55
 */
public interface PromoService {
    /** 根据itemId获取即将进行的或正在进行的秒杀活动
     * @param itemId
     * @return
     */
    PromoModel getPromoByItemId(Integer itemId);
}
