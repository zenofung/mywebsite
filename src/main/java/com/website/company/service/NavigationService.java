package com.website.company.service;

import com.website.company.entity.Navigation;
import com.baomidou.mybatisplus.service.IService;
import com.website.company.utils.NavVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface NavigationService extends IService<Navigation> {

    //创建导航
    int addNav(Navigation navigation);

    //跟新导航
    int updateNav(Navigation navigation);

    //根据id获取导航
    Navigation selectById(Integer id);

    Navigation selectByUrl(String url);

    //删除导航
    int delete(Integer id);

    //查看所有导航
    List<Navigation> showAllNav();
}
