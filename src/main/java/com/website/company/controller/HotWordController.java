package com.website.company.controller;

import com.website.company.entity.HotWord;
import com.website.company.service.HotWordService;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hostWord")
public class HotWordController {

    @Autowired
    HotWordService hotWordService;

    @GetMapping("/getList")
    ResponseList<HotWord> getList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return hotWordService.list(page, rows);
    }

    @GetMapping("/get")
    ResponseBo get(@RequestParam("id") Integer id) {
        try {
            HotWord hotWord = hotWordService.selectById(id);
            return ResponseBo.ok(hotWord);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            hotWordService.delete(ids);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo save(@RequestBody HotWord hotWord) {
        if (hotWord.getId() == null) {
            try {
                hotWordService.add(hotWord);
                return ResponseBo.ok("热门词添加成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                hotWordService.update(hotWord);
                return ResponseBo.ok("热门词更新成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }

}
