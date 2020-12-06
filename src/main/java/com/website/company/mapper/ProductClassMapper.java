package com.website.company.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.website.company.entity.ProductClass;

import java.util.List;

public interface ProductClassMapper extends BaseMapper<ProductClass> {

    List<ProductClass> selectProductClass();
}
