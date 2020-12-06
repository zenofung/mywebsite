package com.website.company.utils;

import com.website.company.entity.Navigation;


import java.util.List;

public class NavVO extends Navigation {

    private List<NavVO> children;

    public List<NavVO> getChildren() {
        return children;
    }

    public void setChildren(List<NavVO> children) {
        this.children = children;
    }
}
