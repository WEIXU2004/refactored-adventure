package com.project.template.entity;

import lombok.Data;

/**
 * @author WeiXu
 * @Date 2025/3/21 17:14
 */
@Data
public class Productorder extends BaseEntity{

    private String oid;

    private Integer pid;

    private Integer number;

    private Double price;

}
