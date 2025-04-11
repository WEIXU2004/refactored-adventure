package com.project.template.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author WeiXu
 * @Date 2025/3/21 10:27
 */
@Data
public class Cart extends BaseEntity{

    private Integer uid;

    private Integer pid;

    private Integer number;

    private Double tprice;

    @TableField(exist=false)
    private Product product;
}
