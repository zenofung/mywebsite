package com.website.company.service;

import com.website.company.entity.App;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2019-02-12
 */
public interface AppService extends IService<App> {

    boolean updateApp(App app);

    App showApp();


}
