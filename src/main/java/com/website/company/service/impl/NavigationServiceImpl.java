package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.Navigation;
import com.website.company.mapper.NavigationMapper;
import com.website.company.service.NavigationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.utils.NavVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@Service
public class NavigationServiceImpl extends ServiceImpl<NavigationMapper, Navigation> implements NavigationService {

    @Override
    public int addNav(Navigation navigation) {
        navigation.setCreateDatetime(new Date());
        navigation.setUpdateDatetime(new Date());
        return baseMapper.insert(navigation);
    }

    @Override
    public int updateNav(Navigation navigation) {
        navigation.setUpdateDatetime(new Date());
        return baseMapper.updateById(navigation);
    }

    @Override
    public Navigation selectById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Navigation selectByUrl(String url) {
        return baseMapper.getNavByUtl(url);
    }

    @Override
    public int delete(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<Navigation> showAllNav() {
        return baseMapper.getNavList();
    }


}
