package com.project.template.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.template.entity.Cart;
import com.project.template.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    List<Cart> queryCartInfo(Integer uid);
}

