package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.OrderService;
import com.miaoshaproject.service.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: WY
 * @Date: 2019/8/28 23:43
 */
@Controller("order")
@RequestMapping("/order")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    /** 封装下单请求
     * @param id
     * @return
     */
    public CommonReturnType createOrder(@RequestParam(name = "itemId")Integer id,
                                        @RequestParam(name = "amount")Integer amount) throws BusinessException {
       OrderModel orderModel = orderService.createOrder(null,id,amount);

        return CommonReturnType.create(null);
    }
}
