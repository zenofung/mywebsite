package com.website.company.mapper;

import com.website.company.entity.News;
import com.website.company.entity.NewsClass;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface NewsClassMapper extends BaseMapper<NewsClass> {

        List<NewsClass> selectNewsClass();

        NewsClass selectNewsClassById(@Param("newsId") Integer newsId);
    }