package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.website.company.entity.NewsClass;
import com.website.company.mapper.NewsClassMapper;
import com.website.company.service.NewsClassService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@Service
public class NewsClassServiceImpl extends ServiceImpl<NewsClassMapper, NewsClass> implements NewsClassService {

    @Override
    public void add(NewsClass newsClass) {
        newsClass.setCreateDatetime(new Date());
        newsClass.setUpdateDatetime(new Date());
        baseMapper.insert(newsClass);
    }

    @Override
    public void update(NewsClass newsClass) {
        newsClass.setUpdateDatetime(new Date());
        baseMapper.updateById(newsClass);
    }

    @Override
    public void delete(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public NewsClass show(Integer id) {
       return baseMapper.selectNewsClassById(id);
    }

    @Override
    public List<NewsClass> list() {
        return baseMapper.selectNewsClass();
    }
}
