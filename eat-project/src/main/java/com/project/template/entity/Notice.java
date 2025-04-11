package com.project.template.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.project.template.service.SysUserService;
import lombok.Data;

import java.util.Date;

/**
 * @author WeiXu
 * @Date 2025/3/22 16:50
 */

@Data
public class Notice extends BaseEntity{

    private String name;

    private String content;

    private Date createTime;

    private Integer userId;

    @TableField(exist = false)
    private String username;

    public void selectUsername(SysUserService service){
        SysUser sysUser = service.getById(userId);
        if(sysUser==null){
            return;
        }
        username = sysUser.getUsername();

    }

}

