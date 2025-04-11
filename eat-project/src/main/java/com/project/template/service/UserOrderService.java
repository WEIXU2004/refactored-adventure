package com.project.template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.template.entity.Image;
import com.project.template.entity.UserOrder;

import java.util.List;

public interface UserOrderService extends IService<UserOrder> {
    //创建订单
    void addOrder();

    //根据不同的订单状态来查询结果
    List<UserOrder> queryOrder(String ostate);

}