package com.website.company.controller;


import com.website.company.service.SysMenuService;
import com.website.company.utils.SimpleResultDTO;
import com.website.company.utils.SysMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pengyangyan
 * @since 2018-09-28
 */
@RestController
@RequestMapping("/api/sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/get")
    SysMenuDTO get(@RequestParam(value = "id") Integer id){
        return sysMenuService.selectMenu(id);
    }

    @PostMapping("/save")
    SimpleResultDTO save(@RequestBody SysMenuDTO sysMenuDTO){
        return sysMenuService.saveMenu(sysMenuDTO);
    }

    @GetMapping("/list")
    SimpleResultDTO list(){
        List<SysMenuDTO> sysMenuDTOS =  sysMenuService.listMenu();
        return new SimpleResultDTO(sysMenuDTOS);
    }
    @GetMapping("/delete")
    SimpleResultDTO delete(@RequestParam("id") Integer id){
        return sysMenuService.deleteMenu(id);
    }
}
