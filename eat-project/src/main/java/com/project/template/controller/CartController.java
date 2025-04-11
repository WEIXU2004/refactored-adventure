package com.project.template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.common.PageVO;
import com.project.template.common.Result;
import com.project.template.entity.Cart;
import com.project.template.entity.Image;
import com.project.template.exception.CustomException;
import com.project.template.service.CartService;
import com.project.template.service.ImageService;
import com.project.template.utils.Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author WeiXu
 * @Date 2025/3/20 20:43
 */
@RestController  //将数据以json的形式来进行返回
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;

    //分页查询
    @GetMapping("/page")
    public Result<PageVO<Cart>> findPage(
            @RequestParam Map<String, Object> query,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        LambdaQueryWrapper<Cart> wrapper = new LambdaQueryWrapper<>();
        //降序排列
        wrapper.orderByDesc(Cart::getId);
        Page<Cart> page = cartService.page(new Page<>(pageNum, pageSize), wrapper);
        return new Result<>().success(new PageVO<>(page));


    }

    //数据增加
    @PostMapping()
    public Result add(@RequestBody Cart entity){
        cartService.save(entity);
        return new Result<>().success();
    }


    //数据编辑
    @PutMapping()
    public Result update(@RequestBody Cart entity){
        cartService.updateById(entity);
        return new Result<>().success();
    }

    //数据删除
    @DeleteMapping()
    public Result delBatch(@RequestBody List<Integer> ids){
        cartService.removeByIds(ids);
        return new Result<>().success();

    }
    //单个查询
    @GetMapping("/{id}")
    public Result<Image> getById(@PathVariable("id") Integer id){
        return new Result<>().success(cartService.getById(id));
    }

    //控制购物车数量增加和减少
    @GetMapping("changeNumber")
    public Result changeNumber(String cmd,Integer id){
        cartService.changeNumber(cmd,id);
        return new Result<>().success();
    }

    //添加商品到购物车
    @GetMapping("addCart")
    public Result addCart(Cart cart){
        cartService.addCart(cart);
        return new Result<>().success();
    }

    //获取到当前用户添加的商品
    @GetMapping("queryCartInfo")
    public Result<List<Cart>> queryCartInfo(){
        return new Result<>().success(cartService.queryCartInfo(Utils.getUser().getId()));
    }
}
