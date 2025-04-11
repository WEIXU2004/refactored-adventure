package com.project.template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.template.entity.*;
import com.project.template.mapper.CartMapper;
import com.project.template.mapper.ImageMapper;
import com.project.template.mapper.UserOrderMapper;
import com.project.template.service.ImageService;
import com.project.template.service.ProductService;
import com.project.template.service.ProductorderService;
import com.project.template.service.UserOrderService;
import com.project.template.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

    @Resource
    private CartMapper cartMapper;


    @Resource
    private ProductorderService productorderService;


    @Resource
    private ProductService productService;



    //创建订单
    @Override
    public void addOrder() {
        //根据用户id获取目前购物车信息
        Integer userId = Utils.getUser().getId();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");



        //查询购物车中当前用户的商品信息
        LambdaQueryWrapper<Cart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Cart::getUid,userId);
        List<Cart> carts = cartMapper.selectList(wrapper);



        //生成订单
        createOrder(carts,userId,uuid);






        //生成产品订单中间表，通过流水号来进行关联
        createProductOrder(carts,uuid);






        //清空购物车数据
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Cart::getUid,userId);
        cartMapper.selectList(queryWrapper).forEach(v->{
            cartMapper.deleteById(v.getId());
        });


    }




    //根据不同的订单状态来查询结果
    @Override
    public List<UserOrder> queryOrder(String ostate) {
        Integer userId = Utils.getUser().getId();
        LambdaQueryWrapper<UserOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserOrder::getUid,userId);
        //没有传入数据就查全部
        if(!"".equals(ostate)){
            wrapper.eq(UserOrder::getOstate,ostate);
        }



        //根据uid和ostate查询值
        List<UserOrder> orders = list(wrapper);
        orders.forEach(v->{
            LambdaQueryWrapper<Productorder> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Productorder::getOid,v.getOnumber());
            List<Product> arrayList = new ArrayList<>();
            for(Productorder productorder:productorderService.list(queryWrapper)){
                arrayList.add(productService.getById(productorder.getPid()));
            }

            v.setProduct(arrayList);
        });

        return orders;
    }






    //订单创建
    private void createOrder(List<Cart> carts, Integer userId, String uuid) {
        UserOrder order = new UserOrder();
        order.setOtype(0);//默认0：自取
        order.setUid(userId);
        order.setPaystate(1);//默认1：已支付
        order.setOstate(0);//默认0：预定中
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOtime(dateFormat.format(new Date()));

        double totalPrice = 0.0;
        for(int i=0;i<carts.size();i++){
            Cart cart = carts.get(i);
            totalPrice+=cart.getNumber()*cart.getTprice();
        }
        order.setOprice(totalPrice);//总价
        order.setOnumber(uuid);//订单流水号
        save(order);
    }


    private void createProductOrder(List<Cart> carts, String uuid) {
        List<Productorder> list = new ArrayList<>();
        for(int i=0;i<carts.size();i++){
            Cart cart = carts.get(i);
            Productorder productorder = new Productorder();
            productorder.setNumber(cart.getNumber());
            productorder.setOid(uuid);
            productorder.setPid(cart.getPid());
            productorder.setPrice(cart.getTprice());

            list.add(productorder);

        }

        productorderService.saveBatch(list);


    }
}
