package com.project.template.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.project.template.service.TypeService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WeiXu
 * @Date 2025/3/20 20:43
 */
@Data
public class Product extends BaseEntity{

    @ApiModelProperty("产品名称")
    private String pname;

    @ApiModelProperty("关联类型表id")
    private Integer typeid;

    @ApiModelProperty("价格")
    private Double tprice;

    @ApiModelProperty("产品介绍")
    private String tintroduce;

    @ApiModelProperty("图片路径")
    private String pimageurl;

    //忽略该字段
    @TableField(exist = false)
    private String typeName;

    //定义通过typeid查询属性名称的方法
    public void selectTypeName(TypeService typeService){
        Type service = typeService.getById(typeid);
        if(service == null){
            return;
        }
        typeName=service.getTypename();
    }

}
