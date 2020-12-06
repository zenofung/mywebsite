package com.website.company.service;

import com.baomidou.mybatisplus.service.IService;
import com.website.company.entity.ProductClass;

import java.util.List;

public interface ProductClassService extends IService<ProductClass> {

    void add(ProductClass productClass);


    void update(ProductClass productClass);


    void delete(Integer[] ids);


    ProductClass show(Integer id);

    ProductClass selectByName(String name);

    List<ProductClass>  selectProductClassList();

}
