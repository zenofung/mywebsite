package com.website.company.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.ProductFunctionRelation;
import com.website.company.service.ProductFunctionRelationService;
import com.website.company.utils.RelationDTO;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/relation")
public class ProductFunctionRelationController {

    @Autowired
    ProductFunctionRelationService functionRelationService;

    @PostMapping("/delete")
    ResponseBo deleteRelation(@RequestBody Integer[] ids){
        try{
            functionRelationService.deleteBatchIds(Arrays.asList(ids));
            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error();
        }
    }

    @GetMapping("/list")
    ResponseList<ProductFunctionRelation> getList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("functionId") Integer functionId){
        return functionRelationService.getList(page,rows,functionId);
    }

    @GetMapping("/showFunctions")
    List<ProductFunctionRelation> showRelation(@RequestParam("productId") Integer productId){
        return functionRelationService.selectList(new EntityWrapper<ProductFunctionRelation>().eq("product_id",productId));
    }



}
