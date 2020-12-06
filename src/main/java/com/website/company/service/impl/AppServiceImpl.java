package com.website.company.service.impl;

import com.website.company.entity.App;
import com.website.company.mapper.AppMapper;
import com.website.company.service.AppService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author peng yangyan
 * @since 2019-02-12
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements AppService {

    @Override
    public boolean updateApp(App app) {
        if (app.getId() == null) {
            return baseMapper.insert(app) == 1;
        }
        return baseMapper.updateById(app) == 1;
    }

    @Override
    public App showApp() {
        return baseMapper.selectOne(new App());
    }
}
