package com.website.company.service;

import com.baomidou.mybatisplus.service.IService;
import com.website.company.entity.Links;

import java.util.List;

public interface LinksService extends IService<Links> {

    //新增链接类别
    void add(Links links);

    //修改链接类别
    void update(Links links);

    //删除链接类别
    void delete(Integer[] ids);

    //列表
    List<Links> list();
}
