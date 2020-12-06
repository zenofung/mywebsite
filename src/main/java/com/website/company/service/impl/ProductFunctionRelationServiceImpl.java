package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.entity.ProductFunctionRelation;
import com.website.company.mapper.ProductFunctionRelationMapper;
import com.website.company.service.ProductFunctionRelationService;
import com.website.company.utils.RelationDTO;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductFunctionRelationServiceImpl extends ServiceImpl<ProductFunctionRelationMapper, ProductFunctionRelation> implements ProductFunctionRelationService {


    @Autowired
    ProductFunctionRelationService functionRelationService;

    @Override
    public ResponseList<ProductFunctionRelation> getList(Integer page, Integer rows, Integer functionId) {
        ResponseList<ProductFunctionRelation> relationResponseList = new ResponseList<>();
        EntityWrapper<ProductFunctionRelation> entityWrapper = new EntityWrapper<>();
        Integer count = baseMapper.selectCount(entityWrapper);
        if (functionId != null) {
            entityWrapper.eq("function_id", functionId);
        }
        List<ProductFunctionRelation> productFunctionRelations = baseMapper.selectPage(new Page<ProductFunctionRelation>(page, rows), entityWrapper);
        relationResponseList.setTotal(count);
        relationResponseList.setResult(productFunctionRelations);
        return relationResponseList;
    }

    @Override
    public ResponseBo addOrupdateRelation(RelationDTO relationDTO) {
        try {
            functionRelationService.delete(new EntityWrapper<ProductFunctionRelation>().eq("product_id", relationDTO.getProductId()));
            relationDTO.getFunctionId().forEach(v -> {
                functionRelationService.insert(new ProductFunctionRelation(relationDTO.getProductId(), v));
            });
            return ResponseBo.ok();
        } catch (Exception e) {
            return ResponseBo.error(e.getMessage());
        }
    }

    @Override
    public List<Integer> getFunctionIds(Integer productId) {
        List<Integer> ids = new ArrayList<>();
        List<ProductFunctionRelation> relations = baseMapper.selectList(new EntityWrapper<ProductFunctionRelation>().eq("product_id", productId));
        relations.forEach(v -> {
            ids.add(v.getFunctionId());
        });
        return ids;
    }
}
