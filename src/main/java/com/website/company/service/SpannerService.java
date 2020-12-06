package com.website.company.service;

import com.website.company.entity.Spanner;
import com.baomidou.mybatisplus.service.IService;
import com.website.company.utils.ResponseList;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface SpannerService extends IService<Spanner> {

    void add(Spanner spanner);


    void update(Spanner spanner);


    void delete(Integer[] ids);


    Spanner show(Integer id);


    List<Spanner> list();
}
