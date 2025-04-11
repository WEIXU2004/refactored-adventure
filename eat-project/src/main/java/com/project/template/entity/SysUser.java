package com.project.template.entity;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.template.enums.StatusType;
import com.project.template.utils.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "User对象", description = "用户信息表")
public class SysUser extends BaseEntity {

    //数据为""和" "和null的情况下会被拦截
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("个人简介")
    private String content;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("电话")
    private String mobile;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("头像")
    private String img;

    @ApiModelProperty("角色类型")
    private String roleType;

    @ApiModelProperty("加盐")
    private String salt;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("状态 启用/禁用")
    private StatusType status;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    public void encryptedPassword(String password){
        //密码加密
        String salt = Utils.salt();
        setSalt(salt);
        setPassword(SecureUtil.md5(password + salt));
    }
}
