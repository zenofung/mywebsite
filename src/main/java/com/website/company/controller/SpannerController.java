package com.website.company.controller;


import com.website.company.entity.Product;
import com.website.company.entity.Spanner;
import com.website.company.service.BannerInfoService;
import com.website.company.service.SpannerService;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
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
@RequestMapping("/api/spanner")
public class SpannerController {

    @Autowired
    SpannerService spannerService;
    @Autowired
    BannerInfoService bannerInfoService;

    @GetMapping("/getList")
    List<Spanner> getList() {
        return spannerService.list();
    }

    @GetMapping("/get")
    ResponseBo get(@RequestParam("id") Integer id) {
        try {
            Spanner spanner = spannerService.show(id);
            return ResponseBo.ok(spanner);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            spannerService.delete(ids);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo save(@RequestBody Spanner spanner) {
        if (spanner.getId() == null) {
            try {
                spannerService.add(spanner);
                return ResponseBo.ok("添加成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                spannerService.update(spanner);
                return ResponseBo.ok("更新成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }

}
