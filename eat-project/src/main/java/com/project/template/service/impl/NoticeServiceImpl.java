package com.project.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.template.entity.Image;
import com.project.template.entity.Notice;
import com.project.template.mapper.ImageMapper;
import com.project.template.mapper.NoticeMapper;
import com.project.template.service.ImageService;
import com.project.template.service.NoticeService;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
