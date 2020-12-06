package com.website.company.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.Navigation;
import com.website.company.service.NavigationService;
import com.website.company.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/api/navigation")
public class NavigationController {

    @Autowired
    NavigationService navigationService;

    @GetMapping("/getList")
    List<Navigation> getList() {
        return navigationService.showAllNav();
    }

    @GetMapping("/get")
    ResponseBo get(@RequestParam("id") Integer id) {
        try {
            Navigation navigation = navigationService.selectById(id);
            return ResponseBo.ok(navigation);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/delete")
    ResponseBo delete(@RequestParam Integer id) {
        try {
            navigationService.delete(id);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo save(@RequestBody Navigation navigation) {
        if (navigation.getId() == null) {
            try {
                navigationService.addNav(navigation);
                return ResponseBo.ok("添加成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                navigationService.updateNav(navigation);
                return ResponseBo.ok("更新成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }
}
