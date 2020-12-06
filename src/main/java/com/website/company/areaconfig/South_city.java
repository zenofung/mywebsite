package com.website.company.areaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "south-city-area", ignoreUnknownFields = false)
@PropertySource("classpath:area.properties")
@Component
public class South_city {
    private String guangdong;
    private String hunan;
    private String guangxi;
    private String hainan;
    private String fujian;
    private String jiangxi;

    public String getGuangdong() {
        return guangdong;
    }

    public void setGuangdong(String guangdong) {
        this.guangdong = guangdong;
    }

    public String getHunan() {
        return hunan;
    }

    public void setHunan(String hunan) {
        this.hunan = hunan;
    }

    public String getGuangxi() {
        return guangxi;
    }

    public void setGuangxi(String guangxi) {
        this.guangxi = guangxi;
    }

    public String getHainan() {
        return hainan;
    }

    public void setHainan(String hainan) {
        this.hainan = hainan;
    }

    public String getFujian() {
        return fujian;
    }

    public void setFujian(String fujian) {
        this.fujian = fujian;
    }

    public String getJiangxi() {
        return jiangxi;
    }

    public void setJiangxi(String jiangxi) {
        this.jiangxi = jiangxi;
    }
}
