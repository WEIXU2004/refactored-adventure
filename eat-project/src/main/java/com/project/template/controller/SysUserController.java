package com.project.template.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.common.PageVO;
import com.project.template.common.Result;
import com.project.template.dto.EditPasswordDTO;
import com.project.template.dto.SysUserDTO;
import com.project.template.dto.UserLoginDTO;
import com.project.template.dto.UserRegisterDTO;
import com.project.template.entity.SysUser;
import com.project.template.service.SysUserService;
import com.project.template.utils.Utils;
import com.project.template.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Api(value = "用户模块", tags = "用户模块")

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @ApiOperation(value = "用户列表", notes = "")
    @GetMapping("/list")
    public Result<List<SysUser>> list() {
        return new Result<>().success(sysUserService.list());
    }


    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public Result<PageVO<SysUser>> findPage(@RequestParam Map<String, Object> query, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<SysUser> page = sysUserService.page(query, pageNum, pageSize);
        return new Result<>().success(new PageVO<>(page));

    }


    @ApiOperation(value = "数据新增", notes = "数据新增")
    @PostMapping()
    public Result add(@Validated @RequestBody SysUser user) {
        sysUserService.save(user);
        return new Result<>().success();
    }


    @ApiOperation(value = "数据更新", notes = "数据更新")
    @PutMapping()
    public Result updateById(@Validated @RequestBody SysUser user) {
        sysUserService.updateById(user);
        return new Result<>().success();
    }


    @ApiOperation(value = "数据根据id批量删除", notes = "数据根据id批量删除")
    @DeleteMapping()
    public Result delBatch(@RequestBody List<Integer> ids) {
        sysUserService.removeByIds(ids);
        return new Result<>().success();
    }


    @GetMapping("/getById")
    public Result<SysUserVO> getById(@RequestParam("id") Integer id) {
        SysUser byId = sysUserService.getById(id);
        SysUserVO userVO = new SysUserVO();
        BeanUtils.copyProperties(byId, userVO);
        return new Result<>().success(userVO);
    }


    @PostMapping("/login")
    public Result login(@Validated @RequestBody UserLoginDTO userLoginDTO) {
        return new Result<>().success(sysUserService.login(userLoginDTO));
    }


    @PostMapping("/register")
    public Result register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        sysUserService.register(userRegisterDTO);
        return new Result<>().success();
    }


    @PutMapping("/editPassword")
    public Result editPassword(@RequestBody EditPasswordDTO dto) {
        sysUserService.editPassword(dto);
        return new Result<>().success();
    }


    @ApiOperation(value = "密码重置", notes = "密码重置")
    @PostMapping("/resetPassword/{id}")
    public Result resetPassword(@PathVariable Integer id) {
        return new Result<>().success(sysUserService.resetPassword(id));
    }


    @GetMapping("/getUserInfo")
    public Result getUserInfo() {
        SysUser sysUser = sysUserService.getById(Utils.getUser().getId());
        return new Result<>().success(sysUser);
    }


    @GetMapping("queryUserInfo")
    public Result queryUserInfo(){
        SysUser sysUser = sysUserService.getById(Utils.getUser().getId());
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(sysUser,sysUserDTO);
        return new Result<>().success(sysUserDTO);
    }
}
