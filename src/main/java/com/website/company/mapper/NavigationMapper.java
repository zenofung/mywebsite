package com.website.company.mapper;

import com.website.company.entity.Navigation;
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
public interface NavigationMapper extends BaseMapper<Navigation> {

    List<Navigation> getNavList();

    Navigation getNavByUtl(String urlString);

}