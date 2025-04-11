package com.project.template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.template.entity.Cart;
import com.project.template.exception.CustomException;
import com.project.template.mapper.CartMapper;
import com.project.template.service.CartService;
import com.project.template.utils.Utils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Override
    public void changeNumber(String cmd, Integer id) {
        Cart cart = this.getById(id);
        //增加商品数量
        if("add".equals(cmd)){
            cart.setNumber(cart.getNumber() + 1);
        }else {
            //减少商品数量
            int number = cart.getNumber()-1;
            if(number<=0){
                throw new CustomException("商品数量最低为1");
            }
            cart.setNumber(number);
        }
        //将修改的值存储到数据库中
        this.updateById(cart);
    }

    @Override
    public void addCart(Cart cart) {
        //获取用户id
        cart.setUid(Utils.getUser().getId());

        //校验购物车中是否已经存在用户id和商品id
        LambdaQueryWrapper<Cart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Cart::getUid,Utils.getUser().getId());
        wrapper.eq(Cart::getPid,cart.getPid());

        Long count = count(wrapper);
        if(count>=1){
            throw new CustomException("购物车中已经存在");
        }
        save(cart);

    }

    @Override
    public List<Cart> queryCartInfo(Integer uid) {
        return cartMapper.queryCartInfo(uid);
    }
}
