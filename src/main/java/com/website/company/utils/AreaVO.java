package com.website.company.utils;

import java.util.List;

public class AreaVO {
    private String province;
    private List<String> city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }
}
