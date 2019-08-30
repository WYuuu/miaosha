package com.miaoshaproject.service;


import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.service.model.ItemModel;

import java.util.List;

public interface ItemService {

    /**
     * @param itemModel
     * @desc 创建商品
     */
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    /**
     * @desc 商品列表浏览
     * */
    List<ItemModel> listItem();

    /**
     * @param id
     * @desc 商品详情浏览
     */
    ItemModel getItemById(Integer id);

    /**库存扣减
     * @return true false
     */
    boolean decreaseStock(Integer itemId,Integer amount) throws BusinessException;

    /** 商品销量增加
     * @param itemId
     * @param amount
     * @throws BusinessException
     */
    void increaseSales(Integer itemId, Integer amount) throws BusinessException;
}
