package com.website.company.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.website.company.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author pengyangyan
 * @since 2018-09-28
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> getList();
}