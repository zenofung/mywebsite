package com.website.company.utils;

import com.website.company.entity.Product;

import java.util.List;

public class ProductDTO {
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
