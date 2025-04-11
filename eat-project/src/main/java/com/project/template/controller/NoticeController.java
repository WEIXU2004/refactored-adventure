package com.project.template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.common.PageVO;
import com.project.template.common.Result;
import com.project.template.entity.Notice;
import com.project.template.service.NoticeService;
import com.project.template.service.SysUserService;
import com.project.template.utils.Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @author WeiXu
 * @Date 2025/3/19 20:43
 */
@RestController  //将数据以json的形式来进行返回
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @Resource
    private SysUserService sysUserService;

    //列表查询&根据属性来查询 查询一般是get请求
    @GetMapping("/getTypes")
    public Result<List<Notice>> getTypes(){
        List<Notice> list = noticeService.list();

        return new Result<>().success(list);

    }


    //分页查询
    @GetMapping("/page")
    public Result<PageVO<Notice>> findPage(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
        //降序排列
        wrapper.orderByDesc(Notice::getId);

        //条件查询
        if (!"".equals(name)) {
            wrapper.like(Notice::getName,name);
        }

        Page<Notice> page = noticeService.page(new Page<>(pageNum, pageSize), wrapper);
        //调用方法获取用户名
        page.getRecords().forEach(v->{
            v.selectUsername(sysUserService);
        });
        return new Result<>().success(new PageVO<>(page));


    }

    //数据增加
    @PostMapping()
    public Result add(@RequestBody Notice entity){

        //设置创建时间
        entity.setCreateTime(new Date());

        //设置用户创建的id
        entity.setUserId(Utils.getUser().getId());

        noticeService.save(entity);
        return new Result<>().success();
    }


    //数据编辑
    @PutMapping()
    public Result update(@RequestBody Notice entity){
        noticeService.updateById(entity);
        return new Result<>().success();
    }

    //数据删除
    @DeleteMapping()
    public Result delBatch(@RequestBody List<Integer> ids){
        noticeService.removeByIds(ids);
        return new Result<>().success();

    }
    //单个查询
    @GetMapping("/{id}")
    public Result<Notice> getById(@PathVariable("id") Integer id){
        return new Result<>().success(noticeService.getById(id));
    }


    //根据属性来查询
    @GetMapping("/list")
    public Result<List<Notice>> list(){
        List<Notice> list = noticeService.list();
        return new Result<>().success(list);

    }


}