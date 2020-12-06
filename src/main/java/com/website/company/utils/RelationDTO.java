package com.website.company.utils;

import java.util.List;

public class RelationDTO {

    private Integer productId;
    private List<Integer> functionId;

    public RelationDTO() {
    }

    public RelationDTO(Integer productId, List<Integer> functionId) {
        this.productId = productId;
        this.functionId = functionId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Integer> getFunctionId() {
        return functionId;
    }

    public void setFunctionId(List<Integer> functionId) {
        this.functionId = functionId;
    }
}
