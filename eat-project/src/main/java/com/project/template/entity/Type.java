package com.project.template.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WeiXu
 * @Date 2025/3/20 10:19
 */
@Data
public class Type extends BaseEntity{
    @ApiModelProperty("类型名称")
    private String typename;

    @ApiModelProperty("类型图片路径")
    private String timageurl;

}
