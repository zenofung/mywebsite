package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.website.company.entity.Product;
import com.website.company.entity.ProductClass;
import com.website.company.mapper.ProductClassMapper;
import com.website.company.mapper.ProductMapper;
import com.website.company.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.utils.Code;
import com.website.company.utils.ProductSearchDTO;
import com.website.company.utils.ResponseList;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductClassMapper productClassMapper;

    @Override
    public void add(Product product) {
        product.setCreateDatetime(new Date());
        product.setUpdateDatetime(new Date());
        ProductClass productClass = productClassMapper.selectById(product.getProductClassId());
        product.setProductClassName(productClass.getName());
        baseMapper.insert(product);
    }

    @Override
    public void update(Product product) {
        product.setUpdateDatetime(new Date());
        baseMapper.updateById(product);
    }

    @Override
    public void delete(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public Product show(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public ResponseList<Product> list(Integer page, Integer rows, String keywords, String productClassName) {
        EntityWrapper<Product> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("update_datetime", false);
        int count = baseMapper.selectCount(entityWrapper);
        ResponseList<Product> responses = new ResponseList<>();
        if (!StringUtils.isEmpty(keywords)) {
            String[] split = keywords.split("&");
            Arrays.asList(split).forEach(v -> entityWrapper.like("keywords", v));
        }
        if (!StringUtils.isEmpty(productClassName)) {
            entityWrapper.eq("product_class_name", productClassName);
        }
        List<Product> news = baseMapper.selectPage(new Page<Product>(page, rows), entityWrapper);
        responses.setRows(rows);
        responses.setPage(page);
        responses.setTotal(count);
        responses.setResult(news);
        responses.setTotalPage(count / rows + 1);
        responses.setCode(Code.SUCCESSED);
        responses.setMsg("操作成功");
        return responses;
    }

    @Override
    public ResponseList<Product> listByOne(Integer page, Integer rows, String keywords, String productClassName) {
        EntityWrapper<Product> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("product_class_name", productClassName);
        entityWrapper.orderBy("update_datetime", false);
        int count = baseMapper.selectCount(entityWrapper);
        ResponseList<Product> responses = new ResponseList<>();
        if (!StringUtils.isEmpty(keywords)) {
            String[] split = keywords.split("&");
            Arrays.asList(split).forEach(v -> entityWrapper.like("keywords", v));
        }
        List<Product> news = baseMapper.selectPage(new Page<Product>(page, rows), entityWrapper);
        responses.setRows(rows);
        responses.setPage(page);
        responses.setTotal(count);
        responses.setResult(news);
        responses.setTotalPage(count / rows + 1);
        responses.setCode(Code.SUCCESSED);
        responses.setMsg("操作成功");
        return responses;
    }

    @Override
    public ResponseList<Product> listByFunction(Integer page, Integer rows, String keywords, Integer functionClassId) {
        ResponseList<Product> responses = new ResponseList<>();
        ProductSearchDTO productSearchDTO = new ProductSearchDTO(page, rows, functionClassId, keywords);
        Integer count = baseMapper.findProductCount(productSearchDTO);
        productSearchDTO.setPage((page - 1) * rows);
        List<Product> productList = baseMapper.findProductPage(productSearchDTO);
        responses.setRows(rows);
        responses.setPage(page);
        responses.setTotal(count);
        responses.setResult(productList);
        responses.setTotalPage(count / rows + 1);
        responses.setCode(Code.SUCCESSED);
        responses.setMsg("操作成功");
        return responses;
    }

    @Override
    public List<Product> allProduct() {
        EntityWrapper<Product> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("update_datetime", false);
        return baseMapper.selectList(entityWrapper);
    }

    @Override
    public List<Product> rssProductAll() {
        return baseMapper.rssProductAll();
    }

    @Override
    public List<Product> getByFunctionId(Integer functionId, Integer num) {
        return baseMapper.getbyFunction(functionId, num);
    }

    @Override
    public List<Product> getByKeyword(String keyword) {
        return baseMapper.getByKeyword(keyword);
    }


}
