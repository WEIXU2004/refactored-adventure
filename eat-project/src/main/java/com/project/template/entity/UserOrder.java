package com.project.template.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author WeiXu
 * @Date 2025/3/21 17:14
 */
@Data
public class UserOrder extends BaseEntity{

    private Integer otype;

    private String onumber;

    private Integer uid;

    private Double oprice;

    private Integer paystate;

    private String otime;

    private Integer ostate;

    @TableField(exist = false)
    private List<Product> product;

}
