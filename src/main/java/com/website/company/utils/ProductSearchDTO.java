package com.website.company.utils;

public class ProductSearchDTO {
    private Integer page;
    private Integer rows;
    private Integer functionId;
    private String keywords;

    public ProductSearchDTO() {
    }

    public ProductSearchDTO(Integer page, Integer rows, Integer functionId, String keywords) {
        this.page = page;
        this.rows = rows;
        this.functionId = functionId;
        this.keywords = keywords;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
