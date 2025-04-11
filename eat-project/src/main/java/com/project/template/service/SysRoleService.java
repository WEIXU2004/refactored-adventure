package com.project.template.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.template.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;


public interface SysRoleService extends IService<SysRole> {

    Page<SysRole> page(Map<String, Object> query, Integer pageNum, Integer pageSize);
}
