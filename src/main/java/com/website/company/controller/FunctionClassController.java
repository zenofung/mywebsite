package com.website.company.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.FunctionClass;
import com.website.company.mapper.FunctionClassMapper;
import com.website.company.service.FunctionClassService;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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
@RequestMapping("/api/functionClass")
public class FunctionClassController {

    @Autowired
    FunctionClassService functionClassService;
    @Resource
    private FunctionClassMapper functionClassMapper;

    @GetMapping("/getFunctionClass")
    ResponseBo getFunctionClass(@RequestParam("id") Integer id) {
        try {
            FunctionClass functionClass = functionClassService.showFunction(id);
            return ResponseBo.ok(functionClass);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/getOptionList")
    List<FunctionClass> getList() {
        return functionClassMapper.selectList(new EntityWrapper<FunctionClass>().orderBy("update_datetime", false));
    }


    @GetMapping("/getList")
    ResponseList<FunctionClass> getList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                                        @RequestParam(value = "classCode") Integer classCode) {
        return functionClassService.listFunction(page, rows, classCode);
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            functionClassService.deleteFunction(ids);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/saveFunctionClass")
    ResponseBo saveProductClass(@RequestBody FunctionClass functionClass) {
        if (functionClass.getId() == null) {
            try {
                functionClassService.addFunction(functionClass);
                return ResponseBo.ok(functionClass);
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                functionClassService.editFunction(functionClass);
                return ResponseBo.ok();
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }

}
