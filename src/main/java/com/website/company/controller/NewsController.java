package com.website.company.controller;


import com.website.company.entity.News;
import com.website.company.mapper.NewsMapper;
import com.website.company.service.*;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    NewsService newsService;
    @Resource
    private NewsMapper newsMapper;

    @GetMapping("/getNews")
    ResponseBo getNews(@RequestParam("id") Integer id) {
        try {
            News news = newsMapper.selectById(id);
            return ResponseBo.ok(news);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/getList")
    ResponseList<News> getList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                               String keyword, Integer newsClassId) {
        return newsService.list(page, rows, keyword, newsClassId);
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            newsService.delete(ids);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/saveNews")
    ResponseBo saveNews(@RequestBody News news) {
        if (news.getId() == null) {
            try {
                newsService.add(news);
                return ResponseBo.ok("发布成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                newsService.update(news);
                return ResponseBo.ok("更新成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }

    @GetMapping("/updateTop")
    ResponseBo updateTop(@RequestParam("id") Integer id, @RequestParam(value = "top", defaultValue = "0") Integer top) {
        try {
            newsService.updateTop(id, top);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

}
