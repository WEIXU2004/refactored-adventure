package com.project.template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.common.PageVO;
import com.project.template.common.Result;
import com.project.template.entity.Image;
import com.project.template.entity.UserOrder;
import com.project.template.service.UserOrderService;
import com.project.template.service.UserOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author WeiXu
 * @Date 2025/3/20 20:43
 */
@RestController  //将数据以json的形式来进行返回
@RequestMapping("/userOrder")
public class UserOrderController {

    @Resource
    private UserOrderService userOrderService;


    //列表查询&根据属性来查询 查询一般是get请求
    @GetMapping("/list")
    public Result<List<UserOrder>> list(){
        List<UserOrder> list = userOrderService.list();
        return new Result<>().success(list);
    }


    //分页查询
    @GetMapping("/page")
    public Result<PageVO<UserOrder>> findPage(
            @RequestParam Map<String, Object> query,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        LambdaQueryWrapper<UserOrder> wrapper = new LambdaQueryWrapper<>();
        Page<UserOrder> page = userOrderService.page(new Page<>(pageNum, pageSize), wrapper);
        return new Result<>().success(new PageVO<>(page));
    }

    //数据增加
    @PostMapping()
    public Result add(@RequestBody UserOrder entity){
        userOrderService.save(entity);
        return new Result<>().success();
    }

    //数据编辑
    @PutMapping()
    public Result update(@RequestBody UserOrder entity){
        userOrderService.updateById(entity);
        return new Result<>().success();
    }

    //数据删除
    @DeleteMapping()
    public Result delBatch(@RequestBody List<Integer> ids){
        userOrderService.removeByIds(ids);
        return new Result<>().success();

    }
    //单个查询
    @GetMapping("/{id}")
    public Result<Image> getById(@PathVariable("id") Integer id){
        return new Result<>().success(userOrderService.getById(id));
    }


    //创建订单
    @GetMapping("addOrder")
    public Result addOrder(){
        userOrderService.addOrder();
        return new Result().success();
    }


    //查询状态
    @GetMapping("queryOrder")
    public Result<List<UserOrder>> queryOrder(String ostate){
        return new Result().success(userOrderService.queryOrder(ostate));
    }





}
