package com.project.template.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.template.entity.Cart;
import com.project.template.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

}

