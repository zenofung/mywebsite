package com.website.company.controller;

import com.website.company.entity.NewsClass;

import com.website.company.service.NewsClassService;
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
@RequestMapping("/api/newsClass")
public class NewsClassController {

    @Autowired
    NewsClassService newsClassService;

    @GetMapping("/get")
    ResponseBo getNews(@RequestParam("id") Integer id) {
        try {
            NewsClass newsClass = newsClassService.show(id);
            return ResponseBo.ok(newsClass);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/getList")
    List<NewsClass> getList() {
        return newsClassService.list();
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            newsClassService.delete(ids);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo saveNewsClass(@RequestBody NewsClass newsClass) {
        if (newsClass.getId() == null) {
            try {
                newsClassService.add(newsClass);
                return ResponseBo.ok("新增成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                newsClassService.update(newsClass);
                return ResponseBo.ok("更新成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }
}
