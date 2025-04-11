package com.project.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.template.entity.Image;
import com.project.template.entity.Productorder;
import com.project.template.mapper.ImageMapper;
import com.project.template.mapper.ProductorderMapper;
import com.project.template.service.ImageService;
import com.project.template.service.ProductorderService;
import org.springframework.stereotype.Service;

@Service
public class ProductorderServiceImpl extends ServiceImpl<ProductorderMapper, Productorder> implements ProductorderService {

}
