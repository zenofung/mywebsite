package com.website.company.utils;

import com.website.company.entity.Product;

import java.util.List;

public class ProductVO extends Product {

    private List<Integer> functionId;

    public List<Integer> getFunctionId() {
        return functionId;
    }

    public void setFunctionId(List<Integer> functionId) {
        this.functionId = functionId;
    }
}
