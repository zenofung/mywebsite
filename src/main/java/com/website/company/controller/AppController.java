package com.website.company.controller;


import com.website.company.entity.App;
import com.website.company.service.AppService;
import com.website.company.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author peng yangyan
 * @since 2019-02-12
 */
@RestController
@RequestMapping("/api/app")
public class AppController {

    @Autowired
    AppService appService;

    @PostMapping("/updateApp")
    ResponseBo updateApp(@RequestBody App app) {
        if (appService.updateApp(app)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.error();
        }
    }

    @GetMapping("/getApp")
    ResponseBo getApp() {
        return ResponseBo.ok(appService.showApp());
    }

}
