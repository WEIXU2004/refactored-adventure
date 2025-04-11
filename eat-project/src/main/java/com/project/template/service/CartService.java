package com.project.template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.template.entity.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {

    void changeNumber(String cmd, Integer id);

    void addCart(Cart cart);

    List<Cart> queryCartInfo(Integer uid);
}