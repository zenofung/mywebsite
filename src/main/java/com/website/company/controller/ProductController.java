package com.website.company.controller;


import com.website.company.entity.Product;
import com.website.company.service.ProductFunctionRelationService;
import com.website.company.service.ProductService;
import com.website.company.utils.ProductVO;
import com.website.company.utils.RelationDTO;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductFunctionRelationService productFunctionRelationService;

    @GetMapping("/getProduct")
    ResponseBo getProduct(@RequestParam("id") Integer id) {
        try {
            ProductVO productVO = new ProductVO();
            Product product = productService.show(id);
            BeanUtils.copyProperties(product, productVO, "functionId");
            List<Integer> functionIds = productFunctionRelationService.getFunctionIds(product.getId());
            productVO.setFunctionId(functionIds);
            return ResponseBo.ok(productVO);
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @GetMapping("/getList")
    ResponseList<Product> getList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                                  @RequestParam("keyword") String keyword, @RequestParam("productClassName") String productClassName) {
        return productService.list(page, rows, keyword, productClassName);
    }

    @PostMapping("/delete")
    ResponseBo delete(@RequestBody Integer[] ids) {
        try {
            productService.delete(ids);
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @PostMapping("/saveProduct")
    ResponseBo saveProduct(@RequestBody ProductVO productVO) {
        if (productVO.getId() == null) {
            try {
                Product product = new Product();
                BeanUtils.copyProperties(productVO, product, "functionId");
                productService.add(product);
                productFunctionRelationService.addOrupdateRelation(new RelationDTO(product.getId(), productVO.getFunctionId()));
                return ResponseBo.ok(product);
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        } else {
            try {
                Product product = new Product();
                BeanUtils.copyProperties(productVO, product);
                productService.update(product);
                productFunctionRelationService.addOrupdateRelation(new RelationDTO(product.getId(), productVO.getFunctionId()));
                return ResponseBo.ok(product);
            } catch (Exception e) {
                return ResponseBo.error(e.getMessage());
            }
        }
    }

}
