package com.website.company.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.ProductClass;
import com.website.company.mapper.ProductClassMapper;
import com.website.company.service.ProductClassService;
import com.website.company.utils.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/productClass")
public class ProductClassController {
    @Autowired
    ProductClassService productClassService;
    @Resource
    private ProductClassMapper productClassMapper;

    @GetMapping("/getProductClass")
    ResponseBo getProductClass(@RequestParam("id") Integer id) {
        try {
            ProductClass productClass = productClassService.show(id);
            return ResponseBo.ok(productClass);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/getList")
    List<ProductClass> getList() {
        return productClassMapper.selectList(new EntityWrapper<ProductClass>().orderBy("update_datetime", false));
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            productClassService.delete(ids);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/saveProductClass")
    ResponseBo saveProductClass(@RequestBody ProductClass productClass) {
        if (productClass.getId() == null) {
            try {
                productClassService.add(productClass);
                return ResponseBo.ok(productClass);
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                productClassService.update(productClass);
                return ResponseBo.ok();
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }
}
