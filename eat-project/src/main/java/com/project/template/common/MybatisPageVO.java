package com.project.template.common;

import lombok.Data;

import java.util.List;

@Data
public class MybatisPageVO<T> {
    List<T> list;
    long total;
    public MybatisPageVO(MybatisPageVO<T> page){
        this.setList(page.getList());
        this.setTotal(page.getTotal());
    }
    public MybatisPageVO(){

    }
}
