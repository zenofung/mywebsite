package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.entity.Links;
import com.website.company.mapper.LinksMapper;
import com.website.company.service.LinksService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class LinksServiceImpl extends ServiceImpl<LinksMapper, Links> implements LinksService {
    @Override
    public void add(Links links) {
        links.setCreateDatetime(new Date());
        links.setUpdateDatetime(new Date());
        baseMapper.insert(links);
    }

    @Override
    public void update(Links links) {
        links.setUpdateDatetime(new Date());
        baseMapper.updateById(links);
    }

    @Override
    public void delete(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public List<Links> list() {

        EntityWrapper<Links> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("update_datetime", false);
        return baseMapper.selectList(entityWrapper);
    }
}
