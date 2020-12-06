package com.website.company.utils;

import com.website.company.entity.FunctionClass;
import com.website.company.entity.Product;

import java.util.List;

public class functionClassDTO extends FunctionClass {
    private List<Product> list;

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
