package com.project.template.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.common.PageVO;
import com.project.template.common.Result;
import com.project.template.entity.Type;
import com.project.template.service.TypeService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author WeiXu
 * @Date 2025/3/19 20:43
 */
@RestController //将数据以json的形式进行返回
@RequestMapping("/type")
public class TypeController {
    @Resource
    private TypeService typeService;

    //列表根据属性来查询
    @GetMapping("/getTypes")
    public Result<List<Type>> getTypes() {
        List<Type> list = typeService.list();

        return new Result<>().success(list);

    }
    //分页查询
    @GetMapping("/page")
    public Result<PageVO<Type>> findPage(
            @RequestParam Map<String,Object> query,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        LambdaQueryWrapper<Type> wrapper = new LambdaQueryWrapper<>();
        //降序排列
        wrapper.orderByDesc(Type::getId);
        Page<Type> page = typeService.page(new Page<>(pageNum, pageSize), wrapper);
        return new Result<>().success(new PageVO<>(page));

    }
    //数据增加
    @PostMapping()
    public Result add(@RequestBody Type entity) {
        typeService.save(entity);
        return new Result<>().success();
    }
    //数据更新
    @PutMapping()
    public Result update(@RequestBody Type entity) {
        typeService.updateById(entity);
        return new Result<>().success();
    }
    //数据删除
    @DeleteMapping()
    public Result delBatch(@RequestBody List<Integer> ids){
        typeService.removeByIds(ids);
        return new Result<>().success();
    }
    //单个查询
    @GetMapping("/{id}")
    public Result<Type> getById(@PathVariable("id") Integer id) {
        return new Result<>().success(typeService.getById(id));
    }

    @GetMapping("/list")
    public Result<List<Type>> list() {
        List<Type> list = typeService.list();
        return new Result<>().success(list);

    }
}
