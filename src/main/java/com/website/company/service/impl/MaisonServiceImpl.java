package com.website.company.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.entity.Maison;
import com.website.company.mapper.MaisonMapper;
import com.website.company.service.MaisonService;
import org.springframework.stereotype.Service;

@Service
public class MaisonServiceImpl extends ServiceImpl<MaisonMapper, Maison> implements MaisonService {
}
