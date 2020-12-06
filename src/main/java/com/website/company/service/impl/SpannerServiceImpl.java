package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.NewsClass;
import com.website.company.entity.Spanner;
import com.website.company.mapper.SpannerMapper;
import com.website.company.service.SpannerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.utils.ResponseList;
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
public class SpannerServiceImpl extends ServiceImpl<SpannerMapper, Spanner> implements SpannerService {

    @Override
    public void add(Spanner spanner) {
        spanner.setCreateDatetime(new Date());
        spanner.setUpdateDatetime(new Date());
        baseMapper.insert(spanner);
    }

    @Override
    public void update(Spanner spanner) {
        spanner.setUpdateDatetime(new Date());
        baseMapper.updateById(spanner);
    }

    @Override
    public void delete(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public Spanner show(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Spanner> list() {
        return baseMapper.selectSpannerList();
    }


}
