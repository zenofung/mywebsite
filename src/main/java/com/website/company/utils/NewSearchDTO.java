package com.website.company.utils;

public class NewSearchDTO {
    private Integer page;
    private Integer rows;
    private String condition;
    private Integer newsClassId;

    public NewSearchDTO() {
    }

    public NewSearchDTO(Integer page, Integer rows, String condition, Integer newsClassId) {
        this.page = page;
        this.rows = rows;
        this.condition = condition;
        this.newsClassId = newsClassId;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getNewsClassId() {
        return newsClassId;
    }

    public void setNewsClassId(Integer newsClassId) {
        this.newsClassId = newsClassId;
    }
}
