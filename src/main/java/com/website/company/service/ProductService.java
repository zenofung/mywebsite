package com.website.company.service;

import com.website.company.entity.Product;
import com.baomidou.mybatisplus.service.IService;
import com.website.company.utils.ResponseList;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface ProductService extends IService<Product> {

    void add(Product product);


    void update(Product product);


    void delete(Integer[] ids);


    Product show(Integer id);


    ResponseList<Product> list(Integer page, Integer rows, String keywords, String productClassName);

    ResponseList<Product> listByOne(Integer page, Integer rows,String keywords,String productClassName);

    ResponseList<Product> listByFunction(Integer page, Integer rows,String keywords,Integer functionClassId);

    List<Product> allProduct();

    List<Product> rssProductAll();

    List<Product> getByFunctionId(Integer functionId, Integer num);

    List<Product> getByKeyword(String keyword);
}
