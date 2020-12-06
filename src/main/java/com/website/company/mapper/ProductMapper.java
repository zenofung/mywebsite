package com.website.company.mapper;

import com.website.company.entity.Product;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.website.company.utils.ProductSearchDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface ProductMapper extends BaseMapper<Product> {

    Integer findProductCount(@Param("productSearchDTO") ProductSearchDTO productSearchDTO);

    List<Product> findProductPage(@Param("productSearchDTO") ProductSearchDTO productSearchDTO);

    List<Product> allproduct();

    List<Product> getbyFunction(@Param("functionId") Integer functionId, @Param("num") Integer num);

    List<Product> getByKeyword(@Param("keyword") String keyword);

    List<Product> getProductList();

    List<Product> rssProductAll();

}