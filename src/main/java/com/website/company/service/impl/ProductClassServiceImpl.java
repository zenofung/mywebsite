package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.entity.ProductClass;
import com.website.company.mapper.ProductClassMapper;
import com.website.company.service.ProductClassService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ProductClassServiceImpl extends ServiceImpl<ProductClassMapper, ProductClass> implements ProductClassService {
    @Override
    public void add(ProductClass productClass) {
        productClass.setCreateDatetime(new Date());
        productClass.setUpdateDatetime(new Date());
        baseMapper.insert(productClass);
    }

    @Override
    public void update(ProductClass productClass) {
        productClass.setUpdateDatetime(new Date());
        baseMapper.updateById(productClass);
    }

    @Override
    public void delete(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public ProductClass show(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public ProductClass selectByName(String name) {
        List<ProductClass> list = this.baseMapper.selectList(new EntityWrapper<ProductClass>().eq("name", name));
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<ProductClass> selectProductClassList() {
        return baseMapper.selectProductClass();
    }
}
