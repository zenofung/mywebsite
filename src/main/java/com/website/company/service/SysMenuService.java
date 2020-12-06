package com.website.company.service;

import com.baomidou.mybatisplus.service.IService;
import com.website.company.entity.SysMenu;
import com.website.company.utils.SimpleResultDTO;
import com.website.company.utils.SysMenuDTO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author pengyangyan
 * @since 2018-09-28
 */
public interface SysMenuService extends IService<SysMenu> {

    SimpleResultDTO saveMenu(SysMenuDTO sysMenuDTO);

    SimpleResultDTO deleteMenu(Integer id);

    SysMenuDTO selectMenu(Integer id);

    List<SysMenuDTO> listMenu();


}
