package com.website.company.utils;

import com.website.company.entity.News;
import com.website.company.entity.NewsClass;

import java.util.List;

public class NewsClassDTO extends NewsClass {
    private List<News> list;

    public List<News> getList() {
        return list;
    }

    public void setList(List<News> list) {
        this.list = list;
    }
}
