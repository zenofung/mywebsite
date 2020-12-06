package com.website.company.service;

import com.website.company.entity.NewsClass;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface NewsClassService extends IService<NewsClass> {
    //新增新闻类别
    void add(NewsClass newsClass);

    //修改新闻类别
    void update(NewsClass newsClass);

    //删除新闻类别
    void delete(Integer[] ids);

    //查看新闻类别
    NewsClass show(Integer id);

    //列表
    List<NewsClass> list();

}

