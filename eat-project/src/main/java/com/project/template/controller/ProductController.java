package com.project.template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.common.PageVO;
import com.project.template.common.Result;
import com.project.template.entity.Image;
import com.project.template.entity.Product;
import com.project.template.entity.Type;
import com.project.template.service.ProductService;
import com.project.template.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author WeiXu
 * @Date 2025/3/20 20:43
 */
@RestController  //将数据以json的形式来进行返回
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private TypeService typeService;

    //列表查询&根据属性来查询 查询一般是get请求
    @GetMapping("/list")
    public Result<List<Product>> list(){
        List<Product> list = productService.list();
        return new Result<>().success(list);
    }


    //分页查询
    @GetMapping("/page")
    public Result<PageVO<Product>> findPage(
            @RequestParam Map<String, Object> query,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        Page<Product> page = productService.page(new Page<>(pageNum, pageSize), wrapper);
        page.getRecords().forEach(record->{
            record.selectTypeName(typeService);
        });
        return new Result<>().success(new PageVO<>(page));
    }

    //数据增加
    @PostMapping()
    public Result add(@RequestBody Product entity){
        productService.save(entity);
        return new Result<>().success();
    }

    //数据编辑
    @PutMapping()
    public Result update(@RequestBody Product entity){
        productService.updateById(entity);
        return new Result<>().success();
    }

    //数据删除
    @DeleteMapping()
    public Result delBatch(@RequestBody List<Integer> ids){
        productService.removeByIds(ids);
        return new Result<>().success();

    }
    //单个查询
    @GetMapping("/{id}")
    public Result<Product> getById(@PathVariable("id") Integer id){
        return new Result<>().success(productService.getById(id));
    }

    //根据商品的属性获取列表
    @GetMapping("/queryProductByType")
    public Result<Product> queryProductByType(Integer id){
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Product::getTypeid,id);
        return new Result<>().success(productService.list(wrapper));
    }
}
