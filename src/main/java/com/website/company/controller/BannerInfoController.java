package com.website.company.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.BannerInfo;
import com.website.company.service.BannerInfoService;
import com.website.company.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bannerInfo")
public class BannerInfoController {

    @Autowired
    BannerInfoService bannerInfoService;

    @GetMapping("/get")
    ResponseBo getNews(@RequestParam("id") Integer id) {
        try {
            BannerInfo bannerInfo = bannerInfoService.selectById(id);
            return ResponseBo.ok(bannerInfo);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/getList")
    List<BannerInfo> getList() {
        return bannerInfoService.selectList(new EntityWrapper<BannerInfo>().orderBy("update_datetime", false));
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            bannerInfoService.deleteBatchIds(Arrays.asList(ids));
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    ResponseBo saveNewsClass(@RequestBody BannerInfo bannerInfo) {
        if (bannerInfo.getId() == null) {
            try {
                bannerInfo.setCreateDatetime(new Date());
                bannerInfo.setUpdateDatetime(new Date());
                bannerInfoService.insert(bannerInfo);
                return ResponseBo.ok("新增成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                bannerInfo.setUpdateDatetime(new Date());
                bannerInfoService.updateById(bannerInfo);
                return ResponseBo.ok("更新成功");
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }
}
