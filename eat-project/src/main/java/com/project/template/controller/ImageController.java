package com.project.template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.common.PageVO;
import com.project.template.common.Result;
import com.project.template.entity.Image;
import com.project.template.service.ImageService;
import com.project.template.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author WeiXu
 * @Date 2025/3/19 20:43
 */
@RestController //将数据以json的形式进行返回
@RequestMapping("/image")
public class ImageController {
    @Resource
    private ImageService imageService;


    //列表根据属性来查询
    @GetMapping("/list/{itype}")
    public Result<List<Image>> queryImageByType(@PathVariable("itype") Integer itype) {
        LambdaQueryWrapper<Image> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Image::getItype,itype);
        List<Image> list = imageService.list(wrapper);

        return new Result<>().success(list);

    }
    //分页查询
    @GetMapping("/page")
    public Result<PageVO<Image>> findPage(
            @RequestParam Map<String,Object> query,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        LambdaQueryWrapper<Image> wrapper = new LambdaQueryWrapper<>();
        //降序排列
        wrapper.orderByDesc(Image::getId);

        Page<Image> page = imageService.page(new Page<>(pageNum, pageSize), wrapper);
        return new Result<>().success(new PageVO<>(page));

    }
    //数据增加
    @PostMapping()
    public Result add(@RequestBody Image entity) {
        imageService.save(entity);
        return new Result<>().success();
    }
    //数据更新
    @PutMapping()
    public Result update(@RequestBody Image entity) {
        imageService.updateById(entity);
        return new Result<>().success();
    }
    //数据删除
    @DeleteMapping()
    public Result delBatch(@RequestBody List<Integer> ids){
        imageService.removeByIds(ids);
        return new Result<>().success();
    }
    //单个查询
    @GetMapping("/{id}")
    public Result<Image> getById(@PathVariable("id") Integer id) {
        return new Result<>().success(imageService.getById(id));
    }
}
