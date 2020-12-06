package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.entity.SysMenu;
import com.website.company.mapper.SysMenuMapper;
import com.website.company.service.SysMenuService;
import com.website.company.utils.SimpleResultDTO;
import com.website.company.utils.SysMenuDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author pengyangyan
 * @since 2018-09-28
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public SimpleResultDTO saveMenu(SysMenuDTO sysMenuDTO) {
        SysMenu sysMenu = new SysMenu();
        sysMenuDTO.setUpdateDatetime(new Date());
        sysMenuDTO.setIsDeleted(0);
        try {
            if (sysMenuDTO.getId() == null) {
                BeanUtils.copyProperties(sysMenuDTO, sysMenu);
                sysMenu.setCreateDatetime(new Date());
                if (baseMapper.insert(sysMenu) == 1)
                    return new SimpleResultDTO("新增成功");
                else
                    return new SimpleResultDTO(false, "新增失败");
            } else {
                BeanUtils.copyProperties(sysMenuDTO, sysMenu);
                if (baseMapper.updateById(sysMenu) == 1)
                    return new SimpleResultDTO("修改成功");
                else
                    return new SimpleResultDTO(false, "修改失败");
            }
        } catch (Exception e) {
            return new SimpleResultDTO(false, e.getMessage());
        }

    }

    @Override
    public SimpleResultDTO deleteMenu(Integer id) {
        SysMenu sysMenu = baseMapper.selectById(id);
        try {
            if (sysMenu != null) {
                List<SysMenu> list = baseMapper.selectList(new EntityWrapper<SysMenu>().eq("parent_id", id).eq("is_deleted", 0));
                if (list.size() > 0) {
                    return new SimpleResultDTO(false, "该菜单存在子菜单，不能直接删除！");
                }
                sysMenu.setUpdateDatetime(new Date());
                sysMenu.setIsDeleted(1);
                if (baseMapper.updateById(sysMenu) == 1)
                    return new SimpleResultDTO("删除成功");
                else
                    return new SimpleResultDTO(false, "删除失败");

            } else {
                return new SimpleResultDTO(false, "删除对象不存在");
            }
        } catch (Exception e) {
            return new SimpleResultDTO(false, e.getMessage());
        }


    }

    @Override
    public SysMenuDTO selectMenu(Integer id) {
        SysMenuDTO sysMenuDTO = new SysMenuDTO();
        SysMenu sysMenu = baseMapper.selectById(id);
        if (sysMenu == null)
            return sysMenuDTO;
        BeanUtils.copyProperties(sysMenu, sysMenuDTO);
        return sysMenuDTO;
    }

    @Override
    public List<SysMenuDTO> listMenu() {
        List<SysMenu> all = baseMapper.selectList(new EntityWrapper<SysMenu>().eq("is_deleted", 0).orderBy("menu_pid", true));
        List<SysMenuDTO> allNode = new ArrayList<>();
        for (SysMenu sysMenu : all) {
            List<SysMenuDTO> list = new ArrayList<>();
            SysMenuDTO menuDTO = new SysMenuDTO();
            BeanUtils.copyProperties(sysMenu, menuDTO);
            menuDTO.setChildren(list);
            allNode.add(menuDTO);
        }
        List<SysMenuDTO> firthMenu = allNode.stream().filter(v -> v.getParentId() == 0 || v.getMenuLevel() == 1).collect(Collectors.toList());
        List<SysMenuDTO> secondMenu = allNode.stream().filter(v -> v.getMenuLevel() == 2).collect(Collectors.toList());
        for (SysMenuDTO sysMenuDTO : firthMenu) {
            for (SysMenuDTO menu : secondMenu) {
                if (menu.getParentId().equals(sysMenuDTO.getId())) {
                    sysMenuDTO.getChildren().add(menu);
                }
            }
        }
        return firthMenu;
    }


}
