package com.website.company.mapper;

import com.website.company.entity.Spanner;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface SpannerMapper extends BaseMapper<Spanner> {

    List<Spanner> selectSpannerList();

}