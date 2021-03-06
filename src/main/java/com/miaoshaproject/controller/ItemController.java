package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.ItemVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.model.ItemModel;
import com.miaoshaproject.service.ItemService;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: WY
 * @Date: 2019/8/27 17:45
 */
@Controller("/item")
@RequestMapping("/item")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

//    创建商品的controller
@ResponseBody
@RequestMapping(value = "/create", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    public CommonReturnType createItem(@RequestParam(name = "title")String title,
                                       @RequestParam(name = "description")String description,
                                       @RequestParam(name = "price")BigDecimal price,
                                       @RequestParam(name = "stock")Integer stock,
                                       @RequestParam(name = "imgUrl")String imgUrl) throws BusinessException {
//        封装service请求用来创建商品
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setPrice(price);
        itemModel.setDescription(description);
        itemModel.setStock(stock);
        itemModel.setImgUrl(imgUrl);

        ItemModel itemModelForReturn = itemService.createItem(itemModel);
        ItemVO itemVO = convertItemVOFromModel(itemModelForReturn);

        return CommonReturnType.create(itemVO);
    }

//    商品详情页浏览
@ResponseBody
@RequestMapping(value = "/get", method = {RequestMethod.GET})
    private CommonReturnType getItem(@RequestParam(name = "id", required = false) Integer id){
    ItemModel itemModel = itemService.getItemById(id);

    ItemVO itemVO = convertItemVOFromModel(itemModel);

    return CommonReturnType.create(itemVO);
}

//      商品列表页面浏览
@ResponseBody
@RequestMapping(value = "/list", method = {RequestMethod.GET})
    public CommonReturnType listItem(){
    List<ItemModel> itemModelList = itemService.listItem();

//    使用stream api将list内的itemModel转化为itemVO
    List<ItemVO> itemVOList = itemModelList.stream().map(itemModel -> {
        ItemVO itemVO = this.convertItemVOFromModel(itemModel);
        return itemVO;
    }).collect(Collectors.toList());
    return CommonReturnType.create(itemVOList);
}



    private ItemVO convertItemVOFromModel(ItemModel itemModel){
        if (itemModel == null){
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel,itemVO);
        if (itemModel.getPromoModel() != null){
//            有正在进行的秒杀活动
            itemVO.setPromoStatus(itemModel.getPromoModel().getStatus());
            itemVO.setPromoId(itemModel.getPromoModel().getId());
            itemVO.setStartDate(itemModel.getPromoModel().getStartDate().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
            itemVO.setPromoPrice(itemModel.getPromoModel().getPromoItemPrice());
        }else {
            itemVO.setPromoStatus(0);
        }
        return itemVO;
    }
}
