package com.website.company.service;

import com.baomidou.mybatisplus.service.IService;
import com.website.company.entity.ProductFunctionRelation;
import com.website.company.utils.RelationDTO;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductFunctionRelationService extends IService<ProductFunctionRelation> {

    ResponseList<ProductFunctionRelation> getList(Integer page, Integer rows, Integer functionId);

    ResponseBo addOrupdateRelation(RelationDTO relationDTO);

    List<Integer> getFunctionIds(Integer productId);

}
