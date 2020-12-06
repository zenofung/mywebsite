package com.website.company.controller;


import com.website.company.entity.Links;
import com.website.company.service.LinksService;
import com.website.company.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/links")
public class LinksController {

    @Autowired
    LinksService linksService;

    @GetMapping("/getList")
    List<Links> getList() {
        return linksService.list();
    }

    @GetMapping("/get")
    ResponseBo get(@RequestParam("id") Integer id) {
        try {
            Links links = linksService.selectById(id);
            return ResponseBo.ok(links);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            linksService.delete(ids);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo save(@RequestBody Links links) {
        if (links.getId() == null) {
            try {
                linksService.add(links);
                return ResponseBo.ok("链接添加成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                linksService.update(links);
                return ResponseBo.ok("链接更新成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }
}
